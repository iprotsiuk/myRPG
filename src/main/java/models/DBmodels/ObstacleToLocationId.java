package models.DBmodels;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ObstacleToLocationId implements Serializable {
    int obstacleId;
    int locationId;


    public ObstacleToLocationId(int obstacleId, int locationId) {
        this.obstacleId = obstacleId;
        this.locationId = locationId;
    }

    public ObstacleToLocationId() {
    }


    public int getObstacleId() {
        return obstacleId;
    }

    public void setObstacleId(int obstacleId) {
        this.obstacleId = obstacleId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }


    @Override
    public int hashCode() {
        return Objects.hash(getObstacleId(), getLocationId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObstacleToLocationId)) return false;
        ObstacleToLocationId that = (ObstacleToLocationId) o;
        return Objects.equals(getObstacleId(), that.getObstacleId()) &&
                Objects.equals(getLocationId(), that.getLocationId());
    }
}
