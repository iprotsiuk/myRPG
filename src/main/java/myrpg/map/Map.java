package myrpg.map;

public class Map {
    ILocation[][] map;
    int width;
    int height;

    public Map(int row, int col){
        this.width = row;
        this.height = col;
        this.map = new Location[row][col];
    }

    public void generate(){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                map[i][j] = Location.generateRandomLocation();
            }
        }
    }

    public Graph buildGraph() {
        Graph graph = new Graph(width, height);

        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                initCell(graph, j, i);
            }
        }

        return graph;
    }

    private void initCell(Graph graph, int x, int y) {
        initRelation(graph, x, y, x - 1, y - 1, Math.sqrt(2));
        initRelation(graph, x, y, x + 1, y - 1, Math.sqrt(2));
        initRelation(graph, x, y, x - 1, y + 1, Math.sqrt(2));
        initRelation(graph, x, y, x + 1, y + 1, Math.sqrt(2));

        initRelation(graph, x, y, x - 1, y, 1);
        initRelation(graph, x, y, x + 1, y, 1);
        initRelation(graph, x, y, x, y - 1, 1);
        initRelation(graph, x, y, x, y + 1, 1);
    }

    private void initRelation(Graph graph, int x, int y, int destX, int destY, double cost) {
        if (destX >= width || destX < 0 || destY >= height || destY < 0){
            return;
        }
        graph.addEdge(y, x, destY, destX, cost);
    }
}
