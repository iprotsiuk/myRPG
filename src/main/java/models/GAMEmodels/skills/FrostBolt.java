package models.GAMEmodels.skills;

import models.GAMEmodels.effects.Damage;
import models.GAMEmodels.effects.Effect;
import models.GAMEmodels.effects.EffectType;
import models.GAMEmodels.effects.IEffect;
import units.classes.DamageType;

import java.util.List;

public class FrostBolt implements ISkill{
    int level;
    List<IEffect> effects;


    public FrostBolt(int level) {
        this.level = level;
        setEffectListByLevel(level);
    }

    void setEffectListByLevel(int level){
        effects.add(new Effect(EffectType.slow, level));
        if(level > 5){
            effects.add(new Effect(EffectType.damage, 0, new Damage(DamageType.magical, level*10)));
        }
        if(level > 10){
            effects.add(new Effect(EffectType.stun, level/10));
        }
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public List<IEffect> getEffects() {
        return effects;
    }


}
