package myrpg.items;

import myrpg.effects.IEffect;
import myrpg.items.gear.GearSlots;
import myrpg.units.IUnit;

import java.util.List;

public abstract class Equippable extends Item implements IEquippable{
    GearSlots gearSlot;

    public Equippable(GearSlots gearSlot, ItemType itemType, String itemName, int itemLevel, boolean isUnique, List<IEffect> IEffectList) {
        super(itemType, itemName, itemLevel, isUnique, IEffectList);
    }

    @Override
    public boolean use(IUnit unit) {
        return false;
    }

    @Override
    public boolean unequip(IUnit unit) {
        return false;
    }

    @Override
    public boolean isEquipped(IItem item) {

        return false;
    }

}
