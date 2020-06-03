package myrpg.units;

import myrpg.races.IRace;
import myrpg.units.classes.IClass;

public class Mob extends Unit implements IMove {
    int colsPosition;
    int rowsPosition;
    int radiusOfMovement;

    public Mob(IRace race, IClass _class, int expCost, int level, int colsPosition, int rowsPosition, int radiusOfMovement) {
        super(race, _class, expCost, level);
        this.radiusOfMovement = radiusOfMovement;
        this.colsPosition = colsPosition;
        this.rowsPosition = rowsPosition;
    }


    @Override
    public void move(int colsPosition, int rowsPosition) {

    }

    @Override
    public int getColsPosition() {
        return colsPosition;
    }

    @Override
    public int getRowsPosition() {
        return rowsPosition;
    }

    @Override
    public void pursuit(IMove move) {

    }

    @Override
    public void follow(IMove move) {

    }
}
