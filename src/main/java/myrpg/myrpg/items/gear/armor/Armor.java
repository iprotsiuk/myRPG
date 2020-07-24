package myrpg.items.gear.armor;

import myrpg.items.*;
import myrpg.items.gear.GearConverter;
import myrpg.effects.IEffect;

import java.util.List;

public class Armor extends Equippable {
    ArmorMaterial armorMaterial;


    public Armor(ArmorSlots armorSlot,ArmorMaterial armorMaterial, String itemName, int itemLevel, boolean isUnique, List<IEffect> IEffectList) {
        super(GearConverter.convertToGear(armorSlot), ItemType.armor, itemName, itemLevel, isUnique, IEffectList);
        this.armorMaterial = armorMaterial;
    }

}
