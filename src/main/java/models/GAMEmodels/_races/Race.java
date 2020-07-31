package models.GAMEmodels._races;

import models.GAMEmodels.Stat;

public class Race implements IRace {

    int id;


    int stamina;
    int strength;
    int agility;
    int intellect;

    public Race(int id, int stamina, int strength, int agility, int intellect) {
        this.id = id;
        this.stamina = stamina;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
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
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return null;
    }


}
