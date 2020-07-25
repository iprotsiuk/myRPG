package models.DBmodels;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemToSlotId implements Serializable {
    int itemId;
    int slotId;


    public ItemToSlotId(int itemId, int slotId) {
        this.itemId = itemId;
        this.slotId = slotId;
    }

    public ItemToSlotId() {
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemId(), getSlotId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemToSlotId)) return false;
        ItemToSlotId that = (ItemToSlotId) o;
        return Objects.equals(getItemId(), that.getItemId()) &&
                Objects.equals(getSlotId(), that.getSlotId());
    }
}
