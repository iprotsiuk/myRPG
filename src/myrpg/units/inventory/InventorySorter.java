package myrpg.units.inventory;

import myrpg.items.IEquippable;
import myrpg.items.IItem;
import myrpg.items.ItemType;

import java.util.*;

public class InventorySorter {
    List<IItem> inventory;

    public InventorySorter(List<IItem> inventory){
        this.inventory = inventory;
    }

    static class SortByName implements Comparator<IItem> {
        @Override
        public int compare(IItem item, IItem item2) {
            return item.getItemName().compareTo(item2.getItemName());
        }
    }

    static class SortByItemType implements Comparator<IItem>{
        @Override
        public int compare(IItem item, IItem item2) {
            return item.getItemType().compareTo(item2.getItemType());
        }
    }

    static class SortByGearSlot implements Comparator<IItem>{
        @Override
        public int compare(IItem item, IItem item2) {
            IEquippable IequippableItem = (IEquippable) item;
            IEquippable IequippableItem2 = (IEquippable) item2;
            return IequippableItem.getGearSlotType().compareTo(IequippableItem2.getGearSlotType());
        }
    }


    public void sortByName(){
        Collections.sort(inventory, new SortByName());
    }

    public void sortByItemType(){
        Collections.sort(inventory, new SortByItemType());
        List<List<IItem>> splittedInventory = splitInventory();
        List<IItem> sortedInventory = sortByItemGearSlot(splittedInventory);
        inventory.clear();
        inventory.addAll(sortedInventory);
    }

    private List<List<IItem>> splitInventory(){
        ItemType itemType = inventory.get(0).getItemType();
        List<List<IItem>> list = new LinkedList<>();
        int from = 0;
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getItemType() != itemType){
                list.add(inventory.subList(from, i-1));
                from = i;
            }
        }
        list.add(inventory.subList(from, inventory.size()-1));
        return list;
    }

    private List<IItem> sortByItemGearSlot(List<List<IItem>> list) {
        List<IItem> sortedInventory = new ArrayList<>();
        for(List<IItem> items : list){
            if(items.get(0).getItemType() == ItemType.armor || items.get(0).getItemType() == ItemType.weapon || items.get(0).getItemType() == ItemType.accessoire){
                Collections.sort(items, new SortByGearSlot());
            }
            sortedInventory.addAll(items);
        }
        return sortedInventory;
    }

}
