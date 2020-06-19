import javafx.util.Pair;
import myrpg.map.ILocation;
import myrpg.map.Location;
import myrpg.map.Point;
import myrpg.units.IUnit;
import org.apache.commons.collections4.BidiMap;

import java.util.HashMap;

public class MapGeneratorTest {
    ILocation[][] map;
    BidiMap<ILocation, IUnit> unitsOnLocations;
    HashMap<ILocation, Point> hash;

    public MapGeneratorTest(ILocation[][] map, BidiMap<ILocation, IUnit> unitsOnLocations, HashMap<ILocation, Point> hash){
        this.map = map;
        this.unitsOnLocations = unitsOnLocations;
        this.hash = hash;
    }



    public void generate(){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                Pair<ILocation, IUnit> locationWithUnit = Location.generateRandomLocation();
                map[i][j] = locationWithUnit.getKey();

                if(locationWithUnit.getValue() != null)
                    unitsOnLocations.put(locationWithUnit.getKey(), locationWithUnit.getValue());

                hash.put(locationWithUnit.getKey(), new Point(j, i));
            }
        }
    }
}
