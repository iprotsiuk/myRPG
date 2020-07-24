package models.DBmodels;

import models.DBmodels._classes.Class;

import javax.persistence.*;

@Entity(name = "SkillToClass")
@Table(name = "skill_to_class")
public class SkillToClass {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    int level;

    @ManyToOne
    @MapsId("skillId")
    @JoinColumn(name = "skillId")
    Skill skill;

    @ManyToOne
    @MapsId("classId")
    @JoinColumn(name = "classId")
    Class _class;


}
