package models.GAMEmodels._races;

import models.GAMEmodels.Stat;

public class Race implements IRace {

    int id;
    double strMultiplier;
    double intMultiplier;
    double agiMultiplier;
    double staMultiplier;

    public Race(int id, double strMultiplier, double intMultiplier, double agiMultiplier, double staMultiplier) {
        this.strMultiplier = strMultiplier;
        this.intMultiplier = intMultiplier;
        this.agiMultiplier = agiMultiplier;
        this.staMultiplier = staMultiplier;
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return null;
    }



    @Override
    public double getStatMultiplier(Stat stat) {
        switch (stat){
            case Strength:
                return this.strMultiplier;
            case Agility:
                return this.agiMultiplier;
            case Stamina:
                return this.staMultiplier;
            case Intellect:
                return this.intMultiplier;
        }
        return -1.0;
    }
}
