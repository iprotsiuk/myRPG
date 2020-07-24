package myrpg.items.gear;

import myrpg.items.IItem;

import java.util.List;
import java.util.Map;

public interface IGear {

    boolean isSlotBusy(GearSlotType gearSlot);
    IItem unequip(GearSlotType gearSlot);
    boolean equip(GearSlotType gearSlot, IItem item);
    List<IItem> equipAllInList(List<IItem> items);
    Map<GearSlotType, IItem> getGearList();

}
