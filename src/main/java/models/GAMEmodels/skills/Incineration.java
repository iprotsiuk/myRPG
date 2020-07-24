package models.GAMEmodels.skills;

import models.GAMEmodels.effects.*;
import units.classes.DamageType;

import java.util.List;

public class Incineration implements ISkill{
    int level;
    List<IEffect> effects;


    public Incineration(int level) {
        this.level = level;
        setEffectListByLevel(level);
    }

    void setEffectListByLevel(int level){
        effects.add(new Effect(EffectType.damage, 0, new Damage(DamageType.magical,level*5)));
        if(level > 5){
            effects.add(new Effect(EffectType.damageOverTime, level, new Damage(DamageType.magical, level)));
        }
        if(level > 10){
            effects.add(new Effect(EffectType.reducedResistance, level, new Resistance(level)));
        }

    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public List<IEffect> getEffects() {
        return null;
    }

}
