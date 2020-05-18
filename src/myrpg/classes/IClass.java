package myrpg.classes;

// Archer/Dragon/Footman/swordsman/Vampire/Ghost

public interface IClass {
    int getBaseHp();
    int getBaseArmor();
    int getBaseAttack();
    int getBonusHpPercent();
    int getPhysicalDamageReductionPercent();
    int getMagicalDamageReductionPercent();
    String getClassName();

    AttackType getAttackType();
    MovementType getMovementType();
}
