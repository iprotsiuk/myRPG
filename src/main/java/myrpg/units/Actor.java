package myrpg.units;

import myrpg.races.IRace;
import myrpg.units.classes.IClass;

public class Actor extends Unit implements IMove{
    Point position;

    int experience = 0;


    public Actor(IRace race, IClass _class, int level, int rowsPosition, int colsPosition) {
        super(race, _class, level*1000, level);
        position = new Point(colsPosition, rowsPosition);
    }


    @Override
    public void move(int colsPosition, int rowsPosition) {

    }

    @Override
    public int getPosition() {
        return this.position.colPosition;
    }

    @Override
    public void pursuit(IMove move) {

    }

    @Override
    public void follow(IMove move) {

    }
}
