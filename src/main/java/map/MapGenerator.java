package map;

import javafx.util.Pair;
import models.DBmodels.Obstacle;
import models.GAMEmodels.IUnit;

import java.util.LinkedList;
import java.util.List;

public class MapGenerator {



    public static Obstacle generateRandomObstacle(){
        double randomNumber = Math.random();
        if (randomNumber < 0.34)
            return new Obstacle(ObstacleType.rock);
        else if(randomNumber < 0.67)
            return new Obstacle(ObstacleType.tree);
        else if(randomNumber < 1)
            return new Obstacle(ObstacleType.pit);

        return new Obstacle(ObstacleType.rock);
    }

//    public static void generate() {
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                Pair<ILocation, IUnit> locationWithUnit = Location.generateRandomLocation();
//                map[i][j] = locationWithUnit.getKey();
//
//                if (locationWithUnit.getValue() != null)
//                    unitsOnLocations.put(locationWithUnit.getKey(), locationWithUnit.getValue());
//
//                hash.put(locationWithUnit.getKey(), new Point(j, i));
//            }
//        }
//    }


    public static List<Pair<ILocation, IUnit>> generateEmptyChunk(int rows, int cols) {
        List<Pair<ILocation, IUnit>> locationList = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Pair<ILocation, IUnit> locationWithUnit = new Pair<>(new Location(), null);
                locationList.add(locationWithUnit);
            }
        }
        return locationList;
    }
}
