package models.DBmodels;

import javax.persistence.*;
import java.io.Serializable;


@Entity//(name = "ObstacleToLocation")
@Table(name = "obstacle_to_location")
public class LocationToMap implements Serializable {

    @EmbeddedId
    LocationToMapId locationToMapId;

    @ManyToOne
    @JoinColumn(name = "locationId", referencedColumnName = "id")
    Location location;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    Map map;
}
