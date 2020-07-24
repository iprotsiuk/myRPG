package models.GAMEmodels.skills;

import models.GAMEmodels.effects.Damage;
import models.GAMEmodels.effects.Effect;
import models.GAMEmodels.effects.EffectType;
import models.GAMEmodels.effects.IEffect;
import units.classes.DamageType;

import java.util.List;

public class Rupture implements ISkill {
    int level;
    List<IEffect> effects;


    public Rupture(int level) {
        this.level = level;
        setEffectListByLevel(level);
    }

    void setEffectListByLevel(int level){
        effects.add(new Effect(EffectType.damageOverTime, level*2, new Damage(DamageType.physical, level*10)));
        if(level > 5){
            effects.get(0).getDamage().setDamage(level*15);
        }
        if(level > 10){
            effects.get(0).getDamage().setDamage(level*20);
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
