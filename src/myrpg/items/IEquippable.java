package myrpg.items;

import myrpg.units.IUnit;

public interface IEquippable {
    boolean use(IUnit unit);
    boolean unequip(IUnit unit);
    boolean isEquipped(IItem item);
}
