package myrpg.items.gear;

import myrpg.items.IItem;

import java.util.HashMap;
import java.util.Map;

public class GearSlots implements IGear {
    Map<GearSlotType, IItem> gear = new HashMap<>();

    @Override
    public boolean isSlotBusy(GearSlotType gearSlot) {
        return gear.containsKey(gearSlot);
    }

    @Override
    public IItem unequip(GearSlotType gearSlot) {
        if(gear.containsKey(gearSlot)){
            IItem item = gear.get(gearSlot);
            gear.remove(gearSlot);
            return item;
        }
        return null;
    }

    @Override
    public boolean equip(GearSlotType gearSlot, IItem item) {
        if(gear.containsKey(gearSlot))
            return false;
        if(!item.getPossibleSlots().contains(gearSlot))
            return false;

        gear.put(gearSlot, item);
        return true;
    }


}
