package models.fromDbToGame;

import models.DBmodels.SkillToEffect;
import models.DBmodels.Skill;
import models.GAMEmodels.effects.Effect;
import models.GAMEmodels.effects.IEffect;

import java.util.LinkedList;
import java.util.List;

public class Skill_ {

    Skill skill;

    public Skill_(Skill skill){
        this.skill = skill;
    }


//    public models.GAMEmodels.skills.Skill fromDBToGame(){
//        List<IEffect> effectList = new LinkedList<>();
//        SkillToEffect ste = new SkillToEffect();
//
//
//        models.GAMEmodels.skills.ISkill gskill = new models.GAMEmodels.skills.Skill(skill.getLevel(), effectList);
//    }

}
