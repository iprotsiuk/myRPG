package map;

import myrpg.items.IItem;
import myrpg.units.IUnit;

import java.util.List;

public interface ILocation extends Comparable<ILocation> {
//    List<IItem> checkItemsOnLocation();
//    IItem takeItemFromLocation(IItem item);
//    void addItemToLocation(IItem item);
    boolean hasObstacle();
    long getId();

}
