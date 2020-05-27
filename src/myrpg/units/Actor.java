package myrpg.units;

import myrpg.races.IRace;
import myrpg.units.classes.IClass;

public class Actor extends Unit{
    IMove move;
    int experience = 0;


    public Actor(IRace race, IClass _class, int level) {
        super(race, _class, level*1000, level);
    }
}
