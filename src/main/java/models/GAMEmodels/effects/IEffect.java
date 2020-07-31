package models.GAMEmodels.effects;

public interface IEffect {
    EffectType getEffectType();
    boolean isMagicalEffect();
    int getAmount();
    TargetEffect getTarget();

}
