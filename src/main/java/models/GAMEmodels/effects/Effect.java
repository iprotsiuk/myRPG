package models.GAMEmodels.effects;

public class Effect implements IEffect {

    EffectType effectType;
    Damage damage;
    Resistance resistance;
    Armor armor;
    Heal heal;
    int duration;




    public Effect(EffectType effectType, int duration) {
        this.effectType = effectType;
        this.duration = duration;
    }
    public Effect(EffectType effectType, int duration, Damage damage) {
        this.effectType = effectType;
        this.duration = duration;
        this.damage = damage;
    }
    public Effect(EffectType effectType, int duration, Resistance resistance) {
        this.effectType = effectType;
        this.duration = duration;
        this.resistance = resistance;
    }
    public Effect(EffectType effectType, int duration, Armor armor) {
        this.effectType = effectType;
        this.duration = duration;
        this.armor = armor;
    }
    public Effect(EffectType effectType, int duration, Heal heal) {
        this.effectType = effectType;
        this.duration = duration;
        this.heal = heal;
    }

    @Override
    public EffectType getEffectType() {
        return effectType;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public Damage getDamage() {
        return damage;
    }

    @Override
    public Heal getHeal() {
        return heal;
    }

    @Override
    public Resistance getResistance() {
        return resistance;
    }

    public Armor getArmor() {
        return armor;
    }


    public void setEffectType(EffectType effectType) {
        this.effectType = effectType;
    }

    public void setDamage(Damage damage) {
        this.damage = damage;
    }

    public void setResistance(Resistance resistance) {
        this.resistance = resistance;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void setHeal(Heal heal) {
        this.heal = heal;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
