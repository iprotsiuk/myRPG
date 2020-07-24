package myrpg.items.gear.weapon.twohanded;

import myrpg.effects.IEffect;
import myrpg.items.gear.GearSlotType;
import myrpg.items.gear.weapon.Weapon;
import myrpg.items.gear.weapon.WeaponSlots;

import java.util.ArrayList;
import java.util.List;

public class Bow extends Weapon {
    static List<GearSlotType> possibleSlots = new ArrayList<>();

    static {
        possibleSlots.add(GearSlotType.twoHand);
    }

    public Bow(WeaponSlots weaponSlot, String itemName, int itemLevel, boolean isUnique, List<IEffect> IEffectList) {
        super(weaponSlot, itemName, itemLevel, isUnique, IEffectList);
    }

    @Override
    public List<GearSlotType> getPossibleSlots(){
        return this.possibleSlots;
    }

}
