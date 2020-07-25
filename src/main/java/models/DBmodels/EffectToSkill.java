package models.DBmodels;


import javax.persistence.*;
import java.io.Serializable;

@Entity//(name = "EffectToSkill")
@Table(name = "effect_to_skill")
public class EffectToSkill implements Serializable {

        @EmbeddedId
        EffectToSkillId effectToSkillId;

        @ManyToOne
        @JoinColumn(name = "skillId")
        Skill skill;

        @ManyToOne
        @JoinColumn(name = "effectId")
        Effect effect;
}
