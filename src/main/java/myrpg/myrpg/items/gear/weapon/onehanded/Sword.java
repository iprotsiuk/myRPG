package myrpg.items.gear.weapon.onehanded;

import myrpg.effects.IEffect;
import myrpg.items.gear.GearSlotType;
import myrpg.items.gear.weapon.Weapon;
import myrpg.items.gear.weapon.WeaponSlots;

import java.util.ArrayList;
import java.util.List;

public class Sword extends Weapon {

    static List<GearSlotType> possibleSlots = new ArrayList<>();
    static {
        possibleSlots.add(GearSlotType.lHand);
        possibleSlots.add(GearSlotType.rHand);
    }

    public Sword(String itemName, int itemLevel, List<IEffect> IEffectList) {
        super(WeaponSlots.oneHand, itemName, itemLevel, false, IEffectList);
    }

    @Override
    public List<GearSlotType> getPossibleSlots(){
        return this.possibleSlots;
    }
}
