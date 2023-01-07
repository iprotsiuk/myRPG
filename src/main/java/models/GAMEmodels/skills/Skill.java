package models.GAMEmodels.skills;

import models.GAMEmodels.effects.IEffect;

import java.util.List;

public class Skill implements ISkill {
    int level;
    List<IEffect> effects;

    public Skill(int level, List<IEffect> effects) {
        this.level = level;
        this.effects = effects;
    }


    public void setLevel(int level) {
        this.level = level;
    }

    public void setEffects(List<IEffect> effects) {
        this.effects = effects;
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
