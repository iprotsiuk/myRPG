package models.DBmodels;

import javax.persistence.*;


@Entity(name = "UnitToSkill")
@Table(name = "unit_to_skill")
public class UnitToSkill {

    @ManyToOne
    @MapsId("skillId")
    @JoinColumn(name = "skillId")
    Skill skill;

    @ManyToOne
    @MapsId("unitId")
    @JoinColumn(name = "unitId")
    Unit unit;

}
