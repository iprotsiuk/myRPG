package models.DBmodels;


import javax.persistence.*;
import java.io.Serializable;

@Entity//(name = "ObstacleToLocation")
@Table(name = "obstacle_to_location")
public class ObstacleToLocation implements Serializable {

    @EmbeddedId
    ObstacleToLocationId obstacleToLocationId;

    @ManyToOne
    @JoinColumn(name = "obstacleId", referencedColumnName = "id")
    Obstacle obstacle;

    @ManyToOne
    @JoinColumn(name = "locationId", referencedColumnName = "id")
    Location location;


    public ObstacleToLocation() {
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
