package myrpg.map;

import myrpg.items.IItem;
import myrpg.units.IUnit;

import java.util.List;

public interface ILocation {
    IObstacle getObstacleOnLocation();
    List<IItem> checkItemsOnLocation();
    IItem takeItemFromLocation(IItem item);
    void addItemToLocation(IItem item);
    IUnit getUnitOnLocation();
    IUnit removeUnitFromLocation();
    boolean setUnitOnLocation(IUnit unit);
    boolean isAccessibleByUnit();

}
