package myrpg.map;

import myrpg.map.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {
    List<Node> graph;
    int mapWidth;
    int mapHeight;


    public Graph(int mapWidth, int mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        graph = new ArrayList<>(Collections.nCopies(mapHeight*mapWidth, null));
    }

    void addEdge(int rowPosition, int colPosition, int rowPositionDestination, int colPositionDestination, double cost) {
        int index = rowPosition * mapWidth + colPosition;
        int destinationIndex = rowPositionDestination * mapWidth + colPositionDestination;
        if(graph.get(index) == null)
            graph.set(index, new Node(rowPosition, colPosition));
        if(graph.get(destinationIndex) == null)
            graph.set(destinationIndex, new Node(rowPositionDestination, colPositionDestination));

        graph.get(index).addNeighbour(destinationIndex, cost);
        graph.get(destinationIndex).addNeighbour(index, cost);
    }

    public List<Node> getNodes() {
        return graph;
    }

    public Node getFirstNode() {
        return graph.get(0);
    }


    public class Node {
        Point point;
        List<NodeRelation> neighboursIndex = new ArrayList<>();

        public Node (int rowPosition, int colPosition) {
            this.point = new Point(colPosition, rowPosition);
        }

        public void addNeighbour(int index, double cost) {
           if (!neighboursIndex.stream().anyMatch(p -> p.getIndex() == index)) {
               neighboursIndex.add(new NodeRelation(index, cost));
           }
        }

        public Point getPoint() {
            return point;
        }

        public List<NodeRelation> getNeighbours() {
            return neighboursIndex;
        }
    }

    public class NodeRelation {
        public NodeRelation(int index, double cost) {
            this.index = index;
            this.cost = cost;
        }

        private int index;
        private double cost;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }
    }
}
