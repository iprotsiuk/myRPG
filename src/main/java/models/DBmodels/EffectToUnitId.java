package models.DBmodels;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EffectToUnitId implements Serializable {
    int effectId;
    int unitId;


    public EffectToUnitId(int unitId, int effectId) {
        this.unitId = unitId;
        this.effectId = effectId;
    }

    public EffectToUnitId() {
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getEffectId() {
        return effectId;
    }

    public void setEffectId(int effectId) {
        this.effectId = effectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUnitId(), getEffectId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EffectToUnitId)) return false;
        EffectToUnitId that = (EffectToUnitId) o;
        return Objects.equals(getUnitId(), that.getUnitId()) &&
                Objects.equals(getEffectId(), that.getEffectId());
    }
}
