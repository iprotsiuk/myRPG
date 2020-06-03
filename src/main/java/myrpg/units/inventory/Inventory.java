package myrpg.units.inventory;

import myrpg.items.IItem;
import myrpg.items.ItemType;
import myrpg.items.gear.GearSlotType;

import java.util.*;

public class Inventory implements IInventory {
    int size;


    List<IItem> inventory = new ArrayList<>();

    public Inventory (int size){
        this.size = size;
    }

    @Override
    public boolean put(IItem item) {
        if(getEmptySpace() > 0) {
            int temp = findFirstEmptySlot();
            if(temp >= 0)
                inventory.add(temp, item);
            else
                inventory.add(item);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int slotNumber) {
        if (inventory.get(slotNumber) != null){
            inventory.remove(slotNumber);
            return true;
        }
        System.out.println("this slot is empty");
        return false;
    }

    @Override
    public IItem checkSlot(int slotNumber) {
        return inventory.get(slotNumber);
    }

    @Override
    public void sort(SortType sortType) {
        InventorySorter inventorySorter = new InventorySorter(inventory);
        if(sortType == SortType.itemType)
            inventorySorter.sortByItemType();
        else if(sortType == SortType.name)
            inventorySorter.sortByName();
    }


    @Override
    public int getEmptySpace() {
        return size - getOccupiedSpace();
    }

    @Override
    public int getTotalSpace() {
        return size;
    }

    @Override
    public int getOccupiedSpace() {
        int space = 0;
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i) != null)
                space++;
        }
        return space;
    }

    @Override
    public List<IItem> getInventoryContent() {
        return inventory;
    }

    @Override
    public List<IItem> getFilteredInventory(ItemType itemType) {
        List<IItem> filteredInventory = new ArrayList<>();
        for(IItem item : inventory){
            if(item.getItemType() == itemType){
                filteredInventory.add(item);
            }
        }
        return filteredInventory;
    }

    @Override
    public List<IItem> putAllInList(List<IItem> items) {
        List<IItem> notEquipped = new LinkedList<>();

        for(IItem item : items){
            if(!put(item))
                notEquipped.add(item);
        }
        return notEquipped;
    }




    private int findFirstEmptySlot(){
        for (int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i) == null){
                return i;
            }
        }
        return  -1;
    }

}
