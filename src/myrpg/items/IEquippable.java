package myrpg.items;

import myrpg.items.gear.GearSlotType;
import myrpg.items.gear.GearSlots;
import myrpg.units.IUnit;

public interface IEquippable {
    boolean use(IUnit unit);
    boolean unequip(IUnit unit);
    boolean isEquipped(IItem item);
    GearSlotType getGearSlotType();
}
