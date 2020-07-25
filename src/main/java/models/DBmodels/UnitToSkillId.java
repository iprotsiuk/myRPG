package models.DBmodels;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UnitToSkillId implements Serializable {

//    @Column(name = "unitId")
    private int unitId;
//    @Column(name = "skillId")
    private int skillId;



    public UnitToSkillId(int unitId, int skillId) {
        this.unitId = unitId;
        this.skillId = skillId;
    }


    public UnitToSkillId() {
    }


    @Override
    public int hashCode() {
        return Objects.hash(getUnitId(), getSkillId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UnitToSkillId)) return false;
        UnitToSkillId that = (UnitToSkillId) o;
        return Objects.equals(getUnitId(), that.getUnitId()) &&
                Objects.equals(getSkillId(), that.getSkillId());
    }


    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }
}
