package models.GAMEmodels.skills;

import models.GAMEmodels.effects.IEffect;

import java.util.List;

public interface ISkill {
    int getLevel();
    List<IEffect> getEffects();

}
