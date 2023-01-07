package models.GAMEmodels._classes;

import models.GAMEmodels.Stat;

public interface IClass {
    int getId();


    String getName();

    double getStatMultiplier(Stat stat);
}
