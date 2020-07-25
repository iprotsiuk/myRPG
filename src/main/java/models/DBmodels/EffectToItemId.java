package models.DBmodels;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EffectToItemId implements Serializable {
    int effectId;
    int itemId;


    public EffectToItemId(int itemId, int effectId) {
        this.itemId = itemId;
        this.effectId = effectId;
    }

    public EffectToItemId() {
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getEffectId() {
        return effectId;
    }

    public void setEffectId(int effectId) {
        this.effectId = effectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemId(), getEffectId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EffectToItemId)) return false;
        EffectToItemId that = (EffectToItemId) o;
        return Objects.equals(getItemId(), that.getItemId()) &&
                Objects.equals(getEffectId(), that.getEffectId());
    }
}
