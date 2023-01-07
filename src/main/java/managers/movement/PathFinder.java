package managers.movement;

import myrpg.map.IMap;
import myrpg.map.Point;

import java.util.List;

public class PathFinder {
    IMap map;
    MapConverter mapConverter;
    Graph graph;

    public PathFinder(IMap map){
        this.map = map;
        this.mapConverter = new MapConverter(map);
        this.graph = mapConverter.toGraph();
    }

    public List<Point> buildPath(Point currentPosition, Point targetPosition){
        return graph.dijkstra(currentPosition, targetPosition);
    }

}
