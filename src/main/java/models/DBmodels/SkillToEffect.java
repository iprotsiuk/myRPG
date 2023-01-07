package models.DBmodels;


import javax.persistence.*;
import java.io.Serializable;

@Entity//(name = "EffectToSkill")
@Table(name = "effect_to_skill")
public class SkillToEffect implements Serializable {

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

        int duration;
        String description;

        public SkillToEffect() {
        }

        public SkillToEffect(Skill skill, Effect effect, int duration, String description) {
                this.skill = skill;
                this.effect = effect;
                this.duration = duration;
                this.description = description;
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
