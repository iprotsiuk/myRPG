package myrpg.effects;

import myrpg.IUnit;

public interface IEffect {
    boolean addEffect(IUnit unit);
    boolean dispelEffect(IUnit unit);
    String getEffectName();
    String getEffectDescription();
    int getEffectLevel();
}
