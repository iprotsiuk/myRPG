package models.DBmodels;

import javax.persistence.*;
import java.io.Serializable;


@Entity//(name = "UnitToSkill")
@Table(name = "unit_to_skill")
public class UnitToSkill implements Serializable {

    @EmbeddedId
    private UnitToSkillId id;

    @ManyToOne
    @JoinColumn(name = "skillId", referencedColumnName = "id")
    Skill skill;

    @ManyToOne
    @JoinColumn(name = "unitId", referencedColumnName = "id")
    Unit unit;


    public UnitToSkill() {
    }


    public UnitToSkillId getId() {
        return id;
    }

    public void setId(UnitToSkillId id) {
        this.id = id;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
