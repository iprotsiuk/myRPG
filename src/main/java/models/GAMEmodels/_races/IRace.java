package models.GAMEmodels._races;


import models.GAMEmodels.Stat;

// Humans+5dmg/Undead+5hp
public interface IRace {
    int getId();

    String getName();

    double getStatMultiplier(Stat stat);

}
