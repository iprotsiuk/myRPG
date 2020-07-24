package models.GAMEmodels._classes;

import models.GAMEmodels.Stat;

public class Class implements IClass{

    int id;

    String name;
    int stamina;
    int strength;
    int agility;
    int intellect;
    double strMultiplier;
    double intMultiplier;
    double agiMultiplier;
    double staMultiplier;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStat(Stat stat) {
        switch (stat){
            case Strength:
                return this.strength;
            case Agility:
                return this.agility;
            case Stamina:
                return this.stamina;
            case Intellect:
                return this.intellect;
        }
        return -1;
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
