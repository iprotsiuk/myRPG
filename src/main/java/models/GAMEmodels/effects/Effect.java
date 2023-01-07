package models.GAMEmodels.effects;

public class Effect implements IEffect {

    EffectType effectType;
    boolean magicalEffect;
    int amount; // amount of heal/damage/whatever
    TargetEffect target; // -1 self; 0 area; 1 target;


    public Effect(EffectType effectType, boolean magicalEffect, int amount, TargetEffect target) {
        this.effectType = effectType;
        this.magicalEffect = magicalEffect;
        this.amount = amount;
        this.target = target;
    }

    @Override
    public EffectType getEffectType() {
        return effectType;
    }

    public void setEffectType(EffectType effectType) {
        this.effectType = effectType;
    }

    public boolean isMagicalEffect() {
        return magicalEffect;
    }

    public void setMagicalEffect(boolean magicalEffect) {
        this.magicalEffect = magicalEffect;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public TargetEffect getTarget() {
        return target;
    }

    public void setTarget(TargetEffect target) {
        this.target = target;
    }
}
