package myrpg.units;

//leave for now

import myrpg.map.Point;

import java.util.List;

public interface IMove {
    List<Point> move(int colsPosition, int rowsPosition);
    Point getCurrentPosition();
    List<Point> moveToAttackRange(IMove movable);
    List<Point> follow(IMove move);
    IUnit getUnit();
}
