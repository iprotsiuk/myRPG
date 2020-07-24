package models.GAMEmodels.effects;

import units.classes.DamageType;

public class Damage {
    DamageType damageType;
    int damage;

    public Damage(DamageType effectDamageType, int damage) {
        this.damageType = effectDamageType;
        this.damage = damage;
    }

    public DamageType damageType() {
        return damageType;
    }

    public void setEffectDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
