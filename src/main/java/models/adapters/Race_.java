package models.adapters;

import models.DBmodels.Race;

public class Race_ {
    Race race;


    public Race_(Race race) {
        this.race = race;
    }


    public models.GAMEmodels._races.IRace fromDBToGame(){
        //(int id, int stamina, int strength, int agility, int intellect)
        return new models.GAMEmodels._races.Race(race.getId(), race.getStamina(), race.getStrength(), race.getAgility(), race.getIntellect());
    }

}
