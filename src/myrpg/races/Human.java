package myrpg.races;

import myrpg.units.classes.AttackType;

public class Human implements IRace {

    @Override
    public int getBonusDamagePercent(AttackType attackType) {
        switch (attackType){
            case MagicalDamage:
                return 0;
            case rangedPhysicalDamage:
                return 5;
            case meleePhysicalDamage:
                return 5;
        }
        return -1;
    }

    @Override
    public int getBonusHp() {
        return 0;
    }


    public String getRaceName() {
        return "Human";
    }
}
