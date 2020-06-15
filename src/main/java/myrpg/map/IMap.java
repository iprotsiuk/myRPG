package myrpg.map;

import myrpg.units.IUnit;

public interface IMap {
    void generate();
    int getHeight();
    int getWidth();
    ILocation getLocation(int col, int row);
    boolean isAccessibleByUnit(int row, int col);
    boolean removeUnit(IUnit unit);
    boolean removeUnit(Point position);
    boolean addUnit(IUnit unit, Point position);
    Point getUnitPosition(IUnit unit);
}
