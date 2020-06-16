package myrpg.units;

import myrpg.map.IMap;
import myrpg.map.Point;
import myrpg.races.IRace;
import myrpg.units.classes.IClass;

import java.util.ArrayList;
import java.util.List;

public class Mob extends Unit implements IMove {
//    Point position;
//    int colsPosition;
//    int rowsPosition;
    int radiusOfMovement;
    MovementController movementController;
    List<Point> reachableLocations;

    public Mob(IRace race, IClass _class, int expCost, int level, MovementController movementController, int radiusOfMovement) {
        super(race, _class, expCost, level);
        this.movementController = movementController;
        this.radiusOfMovement = radiusOfMovement;
        this.reachableLocations = movementController.getReachableLocations(this, radiusOfMovement, speed);
//        this.radiusOfMovement = radiusOfMovement;
//        this.colsPosition = colsPosition;
//        this.rowsPosition = rowsPosition;
//        this.position = point;
    }

    public List<Point> roam(){
//        List<Point> locationsInRange = movementController.getReachableLocations(this, radiusOfMovement, this.speed);
//        IMap map = movementController.getMap();
//        for(Point p : locationsInRange ){
//            if(map.getUnitsOnLocations().containsKey(p))
//                return moveToAttackRange(map.getUnitsOnLocations().get(p));
//        }
        return movementController.roam(this, this.reachableLocations);
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
    public IUnit getUnit() {
        return this;
    }

}
