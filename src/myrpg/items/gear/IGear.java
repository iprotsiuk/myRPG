package myrpg.items.gear;

import myrpg.items.IItem;

public interface IGear {

    boolean isSlotBusy(GearSlotType gearSlot);
    IItem unequip(GearSlotType gearSlot);
    boolean equip(GearSlotType gearSlot, IItem item);

}
