package models.DBmodels;

import javax.persistence.*;
import java.io.Serializable;


@Entity//(name = "ObstacleToLocation")
@Table(name = "location_to_map")
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

    int col;
    int row;


    public LocationToMap(Location location, Map map, int row, int col) {
        this.location = location;
        this.map = map;
        this.col = col;
        this.row = row;
    }

    public LocationToMap() {
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
