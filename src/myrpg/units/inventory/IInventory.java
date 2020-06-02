package myrpg.units.inventory;

import myrpg.items.IItem;
import myrpg.items.ItemType;

import java.util.List;

public interface IInventory {
    boolean put(IItem item);
    boolean remove(int slotNumber);
    IItem checkSlot(int slotNumber);
    void sort(SortType sortType);
    int getEmptySpace();
    int getTotalSpace();
    int getOccupiedSpace();
    List<IItem> getInventoryContent();
    List<IItem> getFilteredInventory(ItemType itemType);
    List<IItem> putAllInList(List<IItem> items);
}
