package myrpg.map;

public class Obstacle implements IObstacle {
    ObstacleType obstacle;

    public Obstacle(ObstacleType obstacle){
        this.obstacle = obstacle;
    }

    public static IObstacle generateRandomObstacle(){
        double randomNumber = Math.random();
        if (randomNumber < 0.34)
            return new Obstacle(ObstacleType.rock);
        else if(randomNumber < 0.67)
            return new Obstacle(ObstacleType.tree);
        else if(randomNumber < 1)
            return new Obstacle(ObstacleType.pit);

        return new Obstacle(ObstacleType.rock);
    }

    @Override
    public ObstacleType getObstacleType() {
        return this.obstacle;
    }
}
