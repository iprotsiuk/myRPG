package myrpg.races;

import myrpg.classes.AttackType;

// Humans+5dmg/Undead+5hp
public interface IRace {
    int getBonusDamagePercent(AttackType attackType);
    int getBonusHp();
//    int getBonusMagicalDamagePercent();
    String getRaceName();
}
