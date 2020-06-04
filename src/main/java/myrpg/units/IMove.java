package myrpg.units;

//leave for now

import myrpg.map.Point;

public interface IMove {
    void move(int colsPosition, int rowsPosition);
    Point getPosition();
    void pursuit(IMove move);
    void follow(IMove move);
}
