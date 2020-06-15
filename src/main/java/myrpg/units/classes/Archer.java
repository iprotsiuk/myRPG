package myrpg.units.classes;

import myrpg.units.MovementType;

public class Archer implements IClass {
    int range = 10;
    private String className = "Archer";

    public Archer() {
    }

    @Override
    public int getBaseHp() {
        return 15;
    }

    @Override
    public int getBaseArmor() {
        return 5;
    }

    @Override
    public int getBaseAttack() {
        return 7;
    }

    @Override
    public int getBaseMagicAttack() {
        return 0;
    }

    @Override
    public int getBaseMagicalResistance() {
        return 0;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public int getRange() {
        return this.range;
    }

    @Override
    public AttackType getAttackType() {
        return AttackType.rangedPhysicalDamage;
    }

    @Override
    public MovementType getMovementType() {
        return MovementType.foot;
    }
}
