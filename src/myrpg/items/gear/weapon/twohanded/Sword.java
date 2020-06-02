package myrpg.items.gear.weapon.twohanded;

import myrpg.effects.IEffect;
import myrpg.items.gear.GearSlotType;
import myrpg.items.gear.weapon.Weapon;
import myrpg.items.gear.weapon.WeaponSlots;

import java.util.ArrayList;
import java.util.List;

public class Sword extends Weapon {
    static List<GearSlotType> possibleSlots = new ArrayList<>();

    static {
        possibleSlots.add(GearSlotType.twoHand);
    }

    public Sword(String itemName, int itemLevel, boolean isUnique, List<IEffect> IEffectList) {
        super(WeaponSlots.twoHand, itemName, itemLevel, isUnique, IEffectList);
    }

    @Override
    public List<GearSlotType> getPossibleSlots(){
        return this.possibleSlots;
    }
}
