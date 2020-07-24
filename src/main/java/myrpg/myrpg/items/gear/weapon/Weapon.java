package myrpg.items.gear.weapon;

import myrpg.effects.IEffect;
import myrpg.items.Equippable;
import myrpg.items.ItemType;
import myrpg.items.gear.GearConverter;

import java.util.List;

public class Weapon extends Equippable {


    public Weapon(WeaponSlots weaponSlot,String itemName, int itemLevel, boolean isUnique, List<IEffect> IEffectList) {
        super(GearConverter.convertToGear(weaponSlot), ItemType.weapon, itemName, itemLevel, isUnique, IEffectList);
    }
}
