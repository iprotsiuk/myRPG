package models.DBmodels;


import javax.persistence.*;
import java.io.Serializable;

@Entity//(name = "EffectToSkill")
@Table(name = "effect_to_skill")
public class EffectToSkill implements Serializable {

//        @EmbeddedId
//        EffectToSkillId effectToSkillId;

        @Id
        @ManyToOne
        @JoinColumn(referencedColumnName = "id")
        Skill skill;

        @Id
        @ManyToOne
        @JoinColumn(referencedColumnName = "id")
        Effect effect;

        public EffectToSkill() {
        }

        public EffectToSkill(Skill skill, Effect effect) {
                this.skill = skill;
                this.effect = effect;
        }




        public Skill getSkill() {
                return skill;
        }

        public void setSkill(Skill skill) {
                this.skill = skill;
        }

        public Effect getEffect() {
                return effect;
        }

        public void setEffect(Effect effect) {
                this.effect = effect;
        }
}
