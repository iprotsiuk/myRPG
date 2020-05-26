package myrpg.items.gear.accesoires.neck;

import myrpg.effects.IEffect;
import myrpg.items.ItemType;
import myrpg.items.gear.GearSlots;
import myrpg.items.gear.accesoires.AccesoireSlots;
import myrpg.items.gear.accesoires.Accessoire;

import java.util.ArrayList;
import java.util.List;

public abstract class Neackle extends Accessoire {
    static List<GearSlots> possibleSlots = new ArrayList<>();

    static {
        possibleSlots.add(GearSlots.neck);
    }

    public Neackle(AccesoireSlots accesoireSlot, ItemType itemType, String itemName, int itemLevel, boolean isUnique, List<IEffect> IEffectList) {
        super(accesoireSlot, itemType, itemName, itemLevel, isUnique, IEffectList);
    }
}
