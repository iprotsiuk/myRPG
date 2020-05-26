package myrpg.items.gear;

import myrpg.items.IItem;

public interface IGear {

    boolean isSlotBusy(GearSlots gearSlot);
    IItem unequip(GearSlots gearSlot);
    boolean equip(GearSlots gearSlot, IItem item);

}
