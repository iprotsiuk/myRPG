package myrpg.races;

import myrpg.units.classes.AttackType;

public class Undead implements IRace {


    @Override
    public int getBonusDamagePercent(AttackType attackType) {
        switch (attackType){
            case MagicalDamage:
                return 5;
            case rangedPhysicalDamage:
                return 0;
            case meleePhysicalDamage:
                return 0;
        }
        return -1;
    }

    @Override
    public int getBonusHp() {
        return 5;
    }

    @Override
    public String getRaceName() {
        return "Undead";
    }
}
