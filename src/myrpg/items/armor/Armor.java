package myrpg.items.armor;

import myrpg.IUnit;
import myrpg.effects.IEffect;
import myrpg.items.Item;
import myrpg.items.ItemType;

import java.util.List;

public class Armor extends Item {
    ArmorSlot armorSlot;
    ArmorMaterial armorMaterial;


    public Armor(ArmorSlot armorSlot, ArmorMaterial armorMaterial, String itemName, int itemLevel, boolean isUnique, List<IEffect> IEffectList) {
        super(ItemType.armor, itemName, itemLevel, isUnique, IEffectList);
        this.armorMaterial = armorMaterial;
        this.armorSlot = armorSlot;
    }

    @Override
    public boolean use(IUnit unit) {
        return false;
    }

    @Override
    public boolean unequip() {
        return false;
    }



}
