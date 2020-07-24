package models.GAMEmodels.effects;

public interface IEffect {
    EffectType getEffectType();
    Damage getDamage();
    int getDuration();
    Heal getHeal();
    Resistance getResistance();
}
