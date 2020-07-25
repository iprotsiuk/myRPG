package models.DBmodels;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemToLocationId implements Serializable {
    int itemId;
    int locationId;


    public ItemToLocationId(int itemId, int locationId) {
        this.itemId = itemId;
        this.locationId = locationId;
    }

    public ItemToLocationId() {
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemId(), getLocationId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemToLocationId)) return false;
        ItemToLocationId that = (ItemToLocationId) o;
        return Objects.equals(getItemId(), that.getItemId()) &&
                Objects.equals(getLocationId(), that.getLocationId());
    }
}
