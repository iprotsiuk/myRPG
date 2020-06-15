package myrpg.map;

import myrpg.map.IMap;
import myrpg.map.Point;

import java.util.LinkedList;
import java.util.List;

public class PathFinder {
    IMap map;
    MapConverter mapConverter;

    public PathFinder(IMap map){
        this.map = map;
        this.mapConverter = new MapConverter(map);
    }

    public List<Point> buildPath(Point currentPosition, Point targetPosition){
        Graph graph = mapConverter.toGraph();

        return graph.dijkstra(currentPosition, targetPosition);
    }

}
