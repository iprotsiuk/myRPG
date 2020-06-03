package myrpg.items.gear.accesoires.trinket;

import myrpg.effects.IEffect;
import myrpg.items.ItemType;
import myrpg.items.gear.GearSlotType;
import myrpg.items.gear.accesoires.AccesoireSlots;
import myrpg.items.gear.accesoires.Accessories;

import java.util.ArrayList;
import java.util.List;

public class Trinket extends Accessories {
    static List<GearSlotType> possibleSlots = new ArrayList<>();

    static {
        possibleSlots.add(GearSlotType.trinket);
    }

    public Trinket(AccesoireSlots accessoriesSlot, ItemType itemType, String itemName, int itemLevel, boolean isUnique, List<IEffect> IEffectList) {
        super(accessoriesSlot, itemType, itemName, itemLevel, isUnique, IEffectList);
    }
}
