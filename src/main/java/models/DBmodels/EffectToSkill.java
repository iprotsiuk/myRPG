package models.DBmodels;

import models.GAMEmodels.effects.Effect;

import javax.persistence.*;
@Entity(name = "EffectToSkill")
@Table(name = "effect_to_skill")
public class EffectToSkill {

        @ManyToOne
        @MapsId("skillId")
        @JoinColumn(name = "skillId")
        Skill skill;

        @ManyToOne
        @MapsId("effectId")
        @JoinColumn(name = "effectId")
        Effect effect;
}
