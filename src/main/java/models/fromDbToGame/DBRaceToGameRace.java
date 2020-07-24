package models.fromDbToGame;

import models.DBmodels._races.Race;

public class DBRaceToGameRace {
    Race race;


    public DBRaceToGameRace(Race race) {
        this.race = race;
    }


    public models.GAMEmodels._races.Race fromDBToGame(){
        return new models.GAMEmodels._races.Race(race.getId(), race.getStrMultiplier(), race.getIntMultiplier(), race.getAgiMultiplier(), race.getStaMultiplier());
    }

}
