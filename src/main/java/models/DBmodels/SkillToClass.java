package models.DBmodels;

import javax.persistence.*;
import java.io.Serializable;

@Entity//(name = "SkillToClass")
@Table(name = "skill_to_class")
public class SkillToClass  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    int level;

    @ManyToOne
    @JoinColumn(name = "skillId",referencedColumnName = "id")
    Skill skill;

    @ManyToOne
    @JoinColumn(name = "classId", referencedColumnName = "id")
    Class _class;

    public SkillToClass() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Class get_class() {
        return _class;
    }

    public void set_class(Class _class) {
        this._class = _class;
    }
}
