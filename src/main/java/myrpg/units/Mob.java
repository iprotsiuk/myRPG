package myrpg.units;

import javafx.util.Pair;
import myrpg.map.Point;
import myrpg.races.IRace;
import myrpg.units.classes.IClass;

import java.util.List;

public class Mob extends Unit implements IMove {
//    Point position;
//    int colsPosition;
//    int rowsPosition;
    int patrolRange;
    MovementController movementController;
    List<Point> reachableLocations;

    public Mob(IRace race, IClass _class, int expCost, int level, MovementController movementController, int patrolRange) {
        super(race, _class, expCost, level);
        this.movementController = movementController;
        this.patrolRange = patrolRange;
        this.reachableLocations = movementController.getReachableLocations(this, patrolRange, speed);
//        this.radiusOfMovement = radiusOfMovement;
//        this.colsPosition = colsPosition;
//        this.rowsPosition = rowsPosition;
//        this.position = point;
    }

    public Pair<List<Point>, IUnit> roam() {
        IUnit nearestUnit = movementController.getNearestUnit(this, patrolRange, this.speed);

        if(nearestUnit == null) {
            List<Point> path = movementController.roam(this, reachableLocations);
            return new Pair(path, null);
        }
        return null;
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
    public List<Point> follow(IMove movable) {
        return movementController.follow(this, movable, this.getSpeed());
    }

    @Override
    public List<Point> moveToAttackRange(IUnit unit) {
        int range = this._getClass().getRange();
        return movementController.moveToAttackRange(this, unit.getMovable(), this.speed, range);
    }

    @Override
    public List<Point> follow(IUnit unit) {
        return  movementController.follow(this, unit.getMovable(), this.getSpeed());
    }

    @Override
    public IUnit getUnit() {
        return this;
    }

    @Override
    public IMove getMovable() {
        return this;
    }

}
