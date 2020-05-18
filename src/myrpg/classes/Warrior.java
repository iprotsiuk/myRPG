package myrpg.classes;

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
    public int getBonusHpPercent() {
        return 0;
    }

    @Override
    public int getPhysicalDamageReductionPercent() {
        return 0;
    }

    @Override
    public int getMagicalDamageReductionPercent() {
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
