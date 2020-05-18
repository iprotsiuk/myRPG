package myrpg.effects;

import myrpg.IUnit;

public class BonusArmor extends Effect{
    int bonusArmor;

    public BonusArmor(int level, int bonusArmor) {
        super("BonusArmor", "Adds " + bonusArmor + " armor", level);
        this.bonusArmor = bonusArmor;
    }


    @Override
    public boolean addEffect(IUnit unit) {
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
