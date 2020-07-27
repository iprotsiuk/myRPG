package models.DBmodels;

import javax.persistence.*;
import java.io.Serializable;


@Entity//(name = "ObstacleToLocation")
@Table(name = "obstacle_to_location")
public class LocationToMap implements Serializable {

//    @EmbeddedId
//    LocationToMapId locationToMapId;

    @Id
    @ManyToOne
    @JoinColumn( referencedColumnName = "id")
    Location location;

    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    Map map;
}
