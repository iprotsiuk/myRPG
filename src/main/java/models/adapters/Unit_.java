package models.adapters;

import models.DBmodels.Unit;
import models.GAMEmodels.IUnit;

public class Unit_ {
    Unit unit;

    public Unit_(Unit unit) {
        this.unit = unit;
    }

    //race class exp

    public IUnit dBUnitToGameUnit() {
        Race_ race = new Race_(unit.getRace());
        Class_ aClass = new Class_(unit.getClassObj());
        IUnit gunit = new models.GAMEmodels.Unit(race.fromDBToGame(), aClass.fromDBToGame(), unit.getExp(), getLevel());


        return gunit;
    }


    private int getLevel(){
        return (int) unit.getExp()/1000;
    }

}
