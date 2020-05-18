package myrpg.items;

import myrpg.IUnit;
import myrpg.effects.IEffect;

import java.util.List;

public interface IItem {
    boolean isUnique();
    ItemType getItemType();
    String getItemName();
    boolean use(IUnit unit);
    boolean unequip();
    int getItemLevel();
    List<IEffect> getEffectsList();
}
