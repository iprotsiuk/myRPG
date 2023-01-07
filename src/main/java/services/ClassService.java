package services;

import models.DBmodels.Class;

import javax.persistence.EntityManager;

public class ClassService extends Service{


    public ClassService(EntityManager em) {
        super(em);
    }

    public Class getClass(int id){
        Class _class = em.find(Class.class, id);
        return _class;
    }
}
