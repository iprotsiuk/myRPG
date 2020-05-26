package myrpg.items;

import myrpg.items.gear.GearSlots;
import myrpg.units.IUnit;
import myrpg.effects.IEffect;

import java.util.List;

public interface IItem {
    boolean isUnique();
    ItemType getItemType();
    String getItemName();
    boolean use(IUnit unit);
    boolean unequip(IUnit unit);
    boolean isEquipped(IItem item);
    int getItemLevel();
    List<IEffect> getEffectsList();
    List<GearSlots> getPossibleSlots();
}
