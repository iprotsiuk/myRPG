package models.DBmodels;


import models.DBmodels._classes.Class;

import javax.persistence.*;

@Entity(name = "ObstacleToLocation")
@Table(name = "obstacle_to_location")
public class ObstacleToLocation {

    @ManyToOne
    @MapsId("obstacleId")
    @JoinColumn(name = "obstacleId")
    Obstacle obstacle;

    @ManyToOne
    @MapsId("locationId")
    @JoinColumn(name = "locationId")
    Location location;
}
