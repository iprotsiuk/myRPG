package models.adapters;


import models.DBmodels.Effect;

public class Effect_  {

    Effect effect;

    public Effect_(models.DBmodels.Effect effect) {
        this.effect = effect;
    }

    //EffectType effectType, boolean magicalEffect, int amount, TargetEffect target
    public models.GAMEmodels.effects.IEffect fromDBToGame(){
        models.GAMEmodels.effects.IEffect gaffect = new models.GAMEmodels.effects.Effect(
            effect.getEffectType(),
            effect.getMagicalEffect(),
            effect.getAmount(),
            effect.getTarget()
        );

        return gaffect;
    }




}
