package myrpg.map;


public class MapConverter {
    IMap map;

    MapConverter(IMap map){
        this.map = map;
    }

    public Graph toGraph(){
        Graph graph = new Graph(map.getWidth(), map.getHeight());
        for(int i = 0; i < map.getHeight(); i++){
            for(int j = 0; j < map.getWidth(); j++){
//                if(!map.isAccessibleByUnit(i,j))
//                    continue;
                //right
                if(j+1 < map.getWidth() && map.isAccessibleByUnit(i,j+1))
                    graph.addEdge(i, j, i, j+1);
                //left
                if(j-1 >= 0 && map.isAccessibleByUnit(i,j-1))
                    graph.addEdge(i, j, i, j-1);
                //down
                if(i+1 < map.getHeight() && map.isAccessibleByUnit(i+1,j))
                    graph.addEdge(i, j, i+1, j);
                //up
                if(i-1 >= 0 && map.isAccessibleByUnit(i-1,j))
                    graph.addEdge(i, j, i-1, j);
            }
        }

        return graph;
    }

}
