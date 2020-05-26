package myrpg.items.gear.accesoires;

import myrpg.effects.IEffect;
import myrpg.items.Equippable;
import myrpg.items.ItemType;
import myrpg.items.gear.GearConverter;

import java.util.List;

public class Accessoire extends Equippable {



    public Accessoire(AccesoireSlots accesoireSlot, ItemType itemType, String itemName, int itemLevel, boolean isUnique, List<IEffect> IEffectList) {
        super(GearConverter.convertToGear(accesoireSlot), itemType, itemName, itemLevel, isUnique, IEffectList);
    }
}
