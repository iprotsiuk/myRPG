package services;

import models.DBmodels.Class;
import models.DBmodels.Race;

import javax.persistence.EntityManager;

public class RaceService extends Service {

    public RaceService(EntityManager em) {
        super(em);
    }


    public Race getRace(int id) {
        Race race = em.find(Race.class, id);
        return race;
    }
}
