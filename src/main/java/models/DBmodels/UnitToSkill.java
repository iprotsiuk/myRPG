package models.DBmodels;

import javax.persistence.*;
import java.io.Serializable;


@Entity//(name = "UnitToSkill")
@Table(name = "unit_to_skill")
public class UnitToSkill implements Serializable {

//    @EmbeddedId
//    private UnitToSkillId id;

    @Id
    @ManyToOne
    @JoinColumn( referencedColumnName = "id")
    Skill skill;

    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    Unit unit;


    public UnitToSkill() {
    }


//    public UnitToSkillId getId() {
//        return id;
//    }
//
//    public void setId(UnitToSkillId id) {
//        this.id = id;
//    }

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
