package myrpg.items;

import myrpg.items.gear.GearSlotType;
import myrpg.units.IUnit;

import java.util.List;

public interface IEquippable {
    boolean use(IUnit unit);
    boolean unequip(IUnit unit);
    boolean isEquipped(IItem item);
    GearSlotType getGearSlotType();

}
