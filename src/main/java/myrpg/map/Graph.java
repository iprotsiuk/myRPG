package myrpg.map;

import myrpg.map.Point;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<Node> graph;
    int mapWidth;
    int mapHeight;


    public Graph(int mapWidth, int mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        graph = new ArrayList<>(mapHeight*mapWidth);
    }



    void addEdge(int rowPosition, int colPosition, int rowPositionDestination, int colPositionDestination) {
        int index = rowPosition * mapWidth + colPosition;
        int destinationIndex = rowPositionDestination * mapWidth + colPositionDestination;
        if(graph.get(index) == null)
            graph.set(index, new Node(rowPosition, colPosition));
        if(graph.get(destinationIndex) == null)
            graph.set(destinationIndex, new Node(rowPositionDestination, colPositionDestination));

        graph.get(index).addNeighbour(destinationIndex);
        graph.get(destinationIndex).addNeighbour(index);
    }


    private class Node {
        Point point;
        List<Integer> neighboursIndex = new ArrayList<>();

        public Node (int rowPosition, int colPosition) {
            this.point = new Point(colPosition, rowPosition);
        }

        public void addNeighbour(int index) {
           neighboursIndex.add(index);
        }

        public Point getPoint() {
            return point;
        }

        public List<Integer> getNeighboursIndex() {
            return neighboursIndex;
        }
    }
}
