package myrpg.units;

import myrpg.map.Point;
import myrpg.races.IRace;
import myrpg.units.classes.IClass;

public class Mob extends Unit implements IMove {
    Point position;
    int colsPosition;
    int rowsPosition;
    int radiusOfMovement;

    public Mob(IRace race, IClass _class, int expCost, int level, int colsPosition, int rowsPosition, int radiusOfMovement, Point point) {
        super(race, _class, expCost, level);
        this.radiusOfMovement = radiusOfMovement;
        this.colsPosition = colsPosition;
        this.rowsPosition = rowsPosition;
        this.position = point;
    }


    @Override
    public void move(int colsPosition, int rowsPosition) {

    }

    @Override
    public Point getPosition() {
        return position;
    }


    @Override
    public void pursuit(IMove move) {

    }

    @Override
    public void follow(IMove move) {

    }
}
