package services;

import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public abstract class Service {
    protected EntityTransaction transaction;
    protected EntityManager em;

    public Service(EntityManager em) {
        this.em = em;
    }


    protected void startTransaction(){
        transaction = em.getTransaction();
        if(!transaction.isActive())
            transaction.begin();
    }

}
