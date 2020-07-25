package models.DBmodels;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LocationToMapId implements Serializable {
    int locationId;
    int mapId;


    public LocationToMapId(int locationId, int mapId) {
        this.mapId = mapId;
        this.locationId = locationId;
    }

    public LocationToMapId() {
    }


    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }


    @Override
    public int hashCode() {
        return Objects.hash(getMapId(), getLocationId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocationToMapId)) return false;
        LocationToMapId that = (LocationToMapId) o;
        return Objects.equals(getMapId(), that.getMapId()) &&
                Objects.equals(getLocationId(), that.getLocationId());
    }
}
