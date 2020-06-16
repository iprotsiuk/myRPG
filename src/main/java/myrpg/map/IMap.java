package myrpg.map;

import myrpg.units.IUnit;
import org.apache.commons.collections4.BidiMap;

public interface IMap {
    void generate();
    int getHeight();
    int getWidth();
    ILocation getLocation(int row, int col);
    boolean isAccessibleByUnit(int row, int col);
    boolean removeUnit(IUnit unit);
    boolean removeUnit(Point position);
    boolean addUnit(IUnit unit, Point position);
    Point getUnitPosition(IUnit unit);
    BidiMap<ILocation, IUnit> getUnitsOnLocations();
}
