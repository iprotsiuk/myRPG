package myrpg.items.gear.accesoires.neck;

import myrpg.effects.IEffect;
import myrpg.items.ItemType;
import myrpg.items.gear.GearSlotType;
import myrpg.items.gear.accesoires.AccesoireSlots;
import myrpg.items.gear.accesoires.Accessories;

import java.util.ArrayList;
import java.util.List;

public class Neackle extends Accessories {
    static List<GearSlotType> possibleSlots = new ArrayList<>();

    static {
        possibleSlots.add(GearSlotType.neck);
    }

    public Neackle(AccesoireSlots accesoireSlot, ItemType itemType, String itemName, int itemLevel, boolean isUnique, List<IEffect> IEffectList) {
        super(accesoireSlot, itemType, itemName, itemLevel, isUnique, IEffectList);
    }
}
