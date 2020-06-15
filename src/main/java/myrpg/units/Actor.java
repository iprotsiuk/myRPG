package myrpg.units;

import myrpg.map.Point;
import myrpg.races.IRace;
import myrpg.units.classes.IClass;

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
    public void move(int colsPosition, int rowsPosition) {
        movementController.move(this, new Point(colsPosition, rowsPosition), this.getSpeed());
    }

    @Override
    public void moveToAttackRange(IMove movable) {
        int range = this._getClass().getRange();
        movementController.moveToAttackRange(this, movable, this.speed, range);
    }

    @Override
    public void follow(IMove move) {
        movementController.follow(this, move, this.getSpeed());
    }


    @Override
    public IUnit getUnit() {
        return this;
    }
}
