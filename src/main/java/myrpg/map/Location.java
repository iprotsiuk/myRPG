package myrpg.map;

import myrpg.factories.ItemFactory;
import myrpg.factories.MonsterFactory;
import myrpg.items.IItem;
import myrpg.units.IUnit;

import java.util.List;

public class Location implements ILocation{
    List<IItem> itemsOnLocation;
    IUnit unitOnLocation;
    IObstacle obstacleOnLocation;

    public static ILocation generateRandomLocation(){
        double randomNumber = Math.random();
        if(randomNumber < 0.15){
            return new Location(Obstacle.generateRandomObstacle());
        }
        else if(randomNumber < 0.2){
            return new Location(MonsterFactory.getRandomUnit());
        }
        else if(randomNumber < 0.3)
            return new Location(ItemFactory.getListRandomItems(), MonsterFactory.getRandomUnit());

        return new Location();
    }

    public Location(List<IItem> items, IUnit unit){
        this.itemsOnLocation = items;
        this.unitOnLocation = unit;
    }

    public Location(List<IItem> items){
        this.itemsOnLocation = items;
    }

    public Location(IObstacle obstacle){
        this.obstacleOnLocation = obstacle;
    }

    public Location(IUnit unit){
        this.unitOnLocation = unit;
    }

    public Location(){

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
    public IUnit getUnitOnLocation() {
        if(this.unitOnLocation != null)
            return this.unitOnLocation;
        return null;
    }



    @Override
    public IUnit removeUnitFromLocation() {
        if(getUnitOnLocation() != null) {
            IUnit temp = getUnitOnLocation();
            setUnitOnLocation(null);
            return temp;
        }
        return null;
    }

    @Override
    public boolean setUnitOnLocation(IUnit unit) {
        if(isAccessibleByUnit()) {
            this.unitOnLocation = unit;
//            unit.location = this;
            return true;
        }
        return false;
    }

    @Override
    public boolean isAccessibleByUnit() {
        if(getObstacleOnLocation() == null && getUnitOnLocation() == null){
            return true;
        }
        return false;
    }

}
