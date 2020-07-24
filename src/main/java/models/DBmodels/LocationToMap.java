package models.DBmodels;

import javax.persistence.*;


@Entity(name = "ObstacleToLocation")
@Table(name = "obstacle_to_location")
public class LocationToMap {
    @ManyToOne
    @MapsId("locationId")
    @JoinColumn(name = "locationId")
    Location location;

    @ManyToOne
    @MapsId("mapId")
    @JoinColumn(name = "mapId")
    Map map;
}
