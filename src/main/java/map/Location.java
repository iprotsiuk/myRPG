package map;

import javafx.util.Pair;


import java.util.List;
import java.util.Objects;

public class Location implements ILocation{
    List<IItem> itemsOnLocation;
    IObstacle obstacleOnLocation;
    static long currentID = 0;
    long id;

    public static Pair<ILocation, IUnit> generateRandomLocation(){
        double randomNumber = Math.random();
        if(randomNumber < 0.15){
            ILocation location = new Location(Obstacle.generateRandomObstacle());
            return new Pair(location, null);
        }
        else if(randomNumber < 0.2){
            IUnit unit = MonsterFactory.getRandomUnit();
            ILocation location = new Location(Obstacle.generateRandomObstacle());
            return new Pair(location, unit);
        }
        else if(randomNumber < 0.3) {
            ILocation location = new Location(ItemFactory.getListRandomItems());
            IUnit unit = MonsterFactory.getRandomUnit();
            return new Pair(location, unit);
        }
        return new Pair(new Location(), null);
    }

    public Location(List<IItem> items){
        this.itemsOnLocation = items;
        this.id = currentID;
        currentID++;
    }

    public Location(IObstacle obstacle){
        this.obstacleOnLocation = obstacle;
        this.id = currentID;
        currentID++;
    }


    public Location(){
        this.id = currentID;
        currentID++;
    }

    @Override
    public IObstacle getObstacleOnLocation() {
        if(this.obstacleOnLocation != null)
            return this.obstacleOnLocation;
        return null;
    }

    @Override
    public List<IItem> checkItemsOnLocation() {
        return this.itemsOnLocation;
    }

    @Override
    public IItem takeItemFromLocation(IItem item) {
        for(int i = 0; i < itemsOnLocation.size(); i++){
            if(itemsOnLocation.get(i).equals(item)){
                IItem temp = itemsOnLocation.get(i);
                itemsOnLocation.remove(i);
                return temp;
            }
        }
        return null;
    }

    @Override
    public void addItemToLocation(IItem item) {
        itemsOnLocation.add(item);
    }

    @Override
    public boolean hasObstacle() {
        if(getObstacleOnLocation() == null){
            return false;
        }
        return true;
    }

    @Override
    public long getId(){
        return this.id;
    }

    @Override
    public int compareTo(ILocation iLocation) {
        return Long.compare(this.id, iLocation.getId());
    }
}
