package myrpg.effects;

import myrpg.units.IUnit;

public class BonusArmor extends Effect{
    int bonusArmor;
    static int multiplier = 2;

    public BonusArmor(int level) {
        super("BonusArmor", "Adds " + level*multiplier + " armor", level);
        this.bonusArmor = level*multiplier;
    }


    @Override
    public boolean addEffect(IUnit unit) {
        unit.addEffect(this);
        unit.increaseArmor(bonusArmor);
        return true;
    }

    @Override
    public boolean dispelEffect(IUnit unit) {
        if(unit.isEffectPresent(this)) {
            unit.decreaseArmor(bonusArmor);
            return true;
        }
        return false;
    }
}
