package myrpg.items.gear;

import myrpg.items.IItem;

import java.util.List;

public interface IGear {

    boolean isSlotBusy(GearSlotType gearSlot);
    IItem unequip(GearSlotType gearSlot);
    boolean equip(GearSlotType gearSlot, IItem item);
    List<IItem> equipAllInList(List<IItem> items);

}
