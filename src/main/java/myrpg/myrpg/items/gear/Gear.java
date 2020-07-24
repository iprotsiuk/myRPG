package myrpg.items.gear;

import myrpg.items.IItem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Gear implements IGear {
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
        if((item.getPossibleSlots().contains(GearSlotType.lHand) || item.getPossibleSlots().contains(GearSlotType.rHand)) && gear.containsKey(GearSlotType.twoHand))
            return false;
        if(item.getPossibleSlots().contains(GearSlotType.twoHand) && (gear.containsKey(GearSlotType.lHand)) || gear.containsKey(GearSlotType.rHand))
            return false;

        gear.put(gearSlot, item);
        return true;
    }

    @Override
    public List<IItem> equipAllInList(List<IItem> items) {
        List<IItem> notEquipped = new LinkedList<>();

        for(IItem item : items){
            for(GearSlotType gearSlot : item.getPossibleSlots()){
                if(!equip(gearSlot, item)){
                    notEquipped.add(item);
                }
            }
        }
        return notEquipped;
    }

    @Override
    public Map<GearSlotType, IItem> getGearList() {
        return this.gear;
    }


}
