package models.GAMEmodels._classes;

import models.GAMEmodels.Stat;

public interface IClass {
    int getId();


    String getName();

    int getStat(Stat stat);
    double getStatMultiplier(Stat stat);
}
