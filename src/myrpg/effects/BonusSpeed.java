package myrpg.effects;

import myrpg.units.IUnit;

public class BonusSpeed extends Effect{
    int val;

    public BonusSpeed(int level) {
        super("Haste", "Increases speed of the unit", level);
        this.val = level;
    }

    @Override
    public boolean addEffect(IUnit unit) {
        unit.addEffect(this);
        unit.increaseSpeed(val);
        return true;
    }

    @Override
    public boolean dispelEffect(IUnit unit) {
        if(unit.isEffectPresent(this)) {
            unit.dispelEffect(this);
            unit.decreaseSpeed(val);
            return true;
        }
        return false;
    }
}
