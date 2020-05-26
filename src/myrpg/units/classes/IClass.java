package myrpg.units.classes;

// Archer/Dragon/Footman/swordsman/Vampire/Ghost

import myrpg.units.MovementType;

public interface IClass {
    int getBaseHp();
    int getBaseArmor();
    int getBaseAttack();
    int getBaseMagicAttack();
    int getBaseMagicalResistance();
    String getClassName();

    AttackType getAttackType();
    MovementType getMovementType();
}
