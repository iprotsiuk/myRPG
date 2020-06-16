package myrpg.units;

import myrpg.map.Point;
import myrpg.races.IRace;
import myrpg.units.classes.IClass;

import java.util.List;

public class Actor extends Unit implements IMove{
    MovementController movementController;

    int experience = 0;


    public Actor(IRace race, IClass _class, int level, MovementController movementController) {
        super(race, _class, level*1000, level);
        this.movementController = movementController;
    }

    @Override
    public Point getCurrentPosition() {
        return movementController.getUnitPosition(this);
    }

    @Override
    public List<Point> move(int rowsPosition, int colsPosition) {
        return movementController.move(this, new Point(rowsPosition, colsPosition), this.getSpeed());
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
