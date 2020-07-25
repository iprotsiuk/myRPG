package models.DBmodels;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EffectToSkillId implements Serializable {
    int effectId;
    int skillId;


    public EffectToSkillId(int skillId, int effectId) {
        this.skillId = skillId;
        this.effectId = effectId;
    }

    public EffectToSkillId() {
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public int getEffectId() {
        return effectId;
    }

    public void setEffectId(int effectId) {
        this.effectId = effectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSkillId(), getEffectId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EffectToSkillId)) return false;
        EffectToSkillId that = (EffectToSkillId) o;
        return Objects.equals(getSkillId(), that.getSkillId()) &&
                Objects.equals(getEffectId(), that.getEffectId());
    }
}
