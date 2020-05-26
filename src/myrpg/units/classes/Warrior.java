package myrpg.units.classes;

import myrpg.units.MovementType;

public class Warrior implements IClass {

    int speed = 5;
    private String className = "Warrior";

    public Warrior(int speed) {
        this.speed = speed;
    }

    @Override
    public int getBaseHp() {
        return 25;
    }

    @Override
    public int getBaseArmor() {
        return 8;
    }

    @Override
    public int getBaseAttack() {
        return 9;
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
    public AttackType getAttackType() {
        return AttackType.meleePhysicalDamage;
    }

    @Override
    public MovementType getMovementType() {
        return MovementType.foot;
    }
}
