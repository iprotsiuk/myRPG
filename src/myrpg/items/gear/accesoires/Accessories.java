package myrpg.items.gear.accesoires;

import myrpg.effects.IEffect;
import myrpg.items.Equippable;
import myrpg.items.ItemType;
import myrpg.items.gear.GearConverter;

import java.util.List;

public class Accessories extends Equippable {



    public Accessories(AccesoireSlots accessoriesSlot, ItemType itemType, String itemName, int itemLevel, boolean isUnique, List<IEffect> IEffectList) {
        super(GearConverter.convertToGear(accessoriesSlot), itemType, itemName, itemLevel, isUnique, IEffectList);
    }
}
