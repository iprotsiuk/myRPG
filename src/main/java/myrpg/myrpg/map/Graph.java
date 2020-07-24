package myrpg.map;

import myrpg.map.Point;

import java.util.*;

@SuppressWarnings("PointlessBooleanExpression")
public class Graph {
    ArrayList<Node> graph;
    int mapWidth;
    int mapHeight;


    public Graph(int mapWidth, int mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.graph = new ArrayList<Node>(Collections.nCopies(mapHeight*mapWidth, null));
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
        Set<Integer> neighboursIndex = new HashSet<>();

        public Node (int rowPosition, int colPosition) {
            this.point = new Point(rowPosition, colPosition);
        }

        public void addNeighbour(int index) {
           neighboursIndex.add(index);
        }

        public Point getPoint() {
            return point;
        }

        public Set<Integer> getNeighboursIndex() {
            return neighboursIndex;
        }
    }

    public List<Point> dijkstra(Point p1, Point p2){
        int startIndex = p1.rowPosition * mapWidth + p1.colPosition;
        int destinationIndex = p2.rowPosition * mapWidth + p2.colPosition;

        boolean[] visitedNodes = new boolean[graph.size()];
        int[] minDistancesFromStart = new int[graph.size()];

        Arrays.fill(minDistancesFromStart, Integer.MAX_VALUE);
        Arrays.fill(visitedNodes, false);

        minDistancesFromStart[startIndex] = 0;


        int closestAvailableNodeToStart = graph.size();
        int minDistanceToClosestAvailableNode = Integer.MAX_VALUE;

        do{
            closestAvailableNodeToStart = graph.size();
            minDistanceToClosestAvailableNode = Integer.MAX_VALUE;
            for(int i = 0; i <graph.size(); i++){
                if(minDistancesFromStart[i] < minDistanceToClosestAvailableNode && visitedNodes[i] == false){
                    closestAvailableNodeToStart = i;
                    minDistanceToClosestAvailableNode = minDistancesFromStart[i];
                }
            }
            if(closestAvailableNodeToStart != graph.size()){
                Set<Integer> neighbours = graph.get(closestAvailableNodeToStart).getNeighboursIndex();
                for(int i : neighbours){
                    int temp = minDistanceToClosestAvailableNode+1;
                    if(temp < minDistancesFromStart[i]){
                        minDistancesFromStart[i] = temp;
                    }
                }
                visitedNodes[closestAvailableNodeToStart] = true;
            }
        }
        while (closestAvailableNodeToStart != graph.size());

        List<Point> path = new LinkedList<>();
        if(minDistancesFromStart[destinationIndex] < Integer.MAX_VALUE){
            minDistanceToClosestAvailableNode = minDistancesFromStart[destinationIndex];
            int end = destinationIndex;
            while (end != startIndex){
                Set<Integer> neighbours = graph.get(end).getNeighboursIndex();
                int temp = minDistanceToClosestAvailableNode-1;
                for(int i : neighbours){
                    if(minDistancesFromStart[i] == temp){
                        end = i;
                        minDistanceToClosestAvailableNode = temp;
                        path.add(graph.get(i).getPoint());
                        break;
                    }
                }
            }
        }
        Collections.reverse(path);
        path.add(p2);
        return path;
    }





















//    public void func(){
//        distanceToNodes[index] = 0;
//        int minIndex = graph.size();
//        int minDistance = Integer.MAX_VALUE;
//
//        do{
//            minIndex = graph.size();
//            minDistance = Integer.MAX_VALUE;
//            for(int i = 0; i <graph.size(); i++){
//                if(distanceToNodes[i] < minDistance && visitedNodes[i] == false){
//                    minIndex = i;
//                    minDistance = distanceToNodes[i];
//                }
//            }
//            if(minIndex != graph.size()){
//                List<Integer> neighbours = graph.get(minIndex).getNeighboursIndex();
//                for(int i : neighbours){
//                    int temp = minDistance+1;
//                    if(temp < distanceToNodes[i]){
//                        distanceToNodes[i] = temp;
//                    }
//                }
//                visitedNodes[minIndex] = true;
//            }
//        }
//        while (minIndex != graph.size());
//
//        if(distanceToNodes[destinationIndex] < Integer.MAX_VALUE){
//            minDistance = distanceToNodes[destinationIndex];
//            int end = destinationIndex;
//            while (end != index){
//                List<Integer> neighbours = graph.get(end).getNeighboursIndex();
//                int temp = minDistance-1;
//                for(int i : neighbours){
//                    if(distanceToNodes[i] == temp){
//                        end = i;
//                        minDistance = temp;
//                        break;
//                    }
//                }
//            }
//        }
//        return null;
//    }

}
