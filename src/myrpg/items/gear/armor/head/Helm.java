package myrpg.items.gear.armor.head;

import myrpg.effects.IEffect;
import myrpg.items.gear.armor.Armor;
import myrpg.items.gear.armor.ArmorMaterial;
import myrpg.items.gear.GearSlots;
import myrpg.items.gear.armor.ArmorSlots;

import java.util.ArrayList;
import java.util.List;

public abstract class Helm extends Armor {

    static List<GearSlots> possibleSlots = new ArrayList<>();

    static {
        possibleSlots.add(GearSlots.head);
    }

    public Helm(ArmorMaterial armorMaterial, String itemName, int itemLevel, List<IEffect> IEffectList) {
        super(ArmorSlots.head, armorMaterial, itemName, itemLevel, false, IEffectList);
    }

    @Override
    public List<GearSlots> getPossibleSlots(){
        return this.possibleSlots;
    }
}
