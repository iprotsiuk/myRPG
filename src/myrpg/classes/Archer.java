package myrpg.classes;

public class Archer implements IClass {
    int range = 10;
    int speed = 5;
    private String className = "Archer";

    public Archer(int speed, int range) {
        this.speed = speed;
        this.range = range;
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
        return AttackType.rangedPhysicalDamage;
    }

    @Override
    public MovementType getMovementType() {
        return MovementType.foot;
    }
}