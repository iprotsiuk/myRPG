package myrpg.map;

public class Map {
    ILocation[][] map;

    public Map(int row, int col){
        this.map = new Location[row][col];
    }

    public void generate(){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                map[i][j] = Location.generateRandomLocation();
            }
        }
    }

}
