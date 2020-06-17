package myrpg.units;

//leave for now

import myrpg.map.Point;

import java.util.List;

public interface IMove {
    List<Point> move(int colsPosition, int rowsPosition);
    Point getCurrentPosition();
    List<Point> moveToAttackRange(IMove movable);
    List<Point> moveToAttackRange(IUnit unit);
    List<Point> follow(IMove move);
    List<Point> follow(IUnit unit);

    default IUnit getUnit(){
        return null;
    }

}
