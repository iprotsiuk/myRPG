package myrpg.units;

import myrpg.map.Point;
import myrpg.races.IRace;
import myrpg.units.classes.IClass;

import java.util.List;

public class Mob extends Unit implements IMove {
//    Point position;
//    int colsPosition;
//    int rowsPosition;
    int radiusOfMovement;
    MovementController movementController;

    public Mob(IRace race, IClass _class, int expCost, int level, MovementController movementController) {
        super(race, _class, expCost, level);
        this.movementController = movementController;
//        this.radiusOfMovement = radiusOfMovement;
//        this.colsPosition = colsPosition;
//        this.rowsPosition = rowsPosition;
//        this.position = point;
    }

    public List<Point> roamAggressively(){

        return  null;
    }

    @Override
    public List<Point> move(int rowsPosition, int colsPosition) {
        return movementController.move(this, new Point(rowsPosition, colsPosition), this.getSpeed());
    }

    @Override
    public Point getCurrentPosition() {
        return movementController.getUnitPosition(this);
    }


    @Override
    public List<Point> moveToAttackRange(IMove movable) {
        int range = this._getClass().getRange();
        return movementController.moveToAttackRange(this, movable, this.speed, range);
    }

    @Override
    public List<Point> follow(IMove move) {
        return movementController.follow(this, move, this.getSpeed());
    }

    @Override
    public IUnit getUnit() {
        return this;
    }

}
