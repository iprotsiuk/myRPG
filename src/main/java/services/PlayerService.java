package services;

import com.google.gson.Gson;
import models.DBmodels.Player;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class PlayerService {
    EntityManager em;
    EntityTransaction transaction;

    public PlayerService(EntityManager em) {
        this.em = em;
    }

    private void startTransaction(){
        transaction = em.getTransaction();
        if(!transaction.isActive())
            transaction.begin();
    }

    public PlayerOrError register(String login, String password){
        Player player = new Player();
        player.setLogin(login);
        player.setPassword(password);

        startTransaction();

        try {
            em.persist(player);
            transaction.commit();
        }catch (ConstraintViolationException e){
            transaction.rollback();
            return new PlayerOrError(e.getMessage());
        }
        return new PlayerOrError(player);
    }

    public PlayerOrError deletePlayer(String login, String password){

        startTransaction();
        CriteriaBuilder uslovie = em.getCriteriaBuilder();
        CriteriaQuery<Player> querry = uslovie.createQuery(Player.class);
        Root<Player> tableName = querry.from(Player.class);
        ParameterExpression<String> uslovieType = uslovie.parameter(String.class);

        querry.select(tableName).where(uslovie.equal(tableName.get("login"), uslovieType));

        TypedQuery<Player> query = em.createQuery(querry);
        query.setParameter(uslovieType, login);
        List<Player> result = query.getResultList();

        System.out.println(result.get(0));

//
//        if(results.size() == 0) {
//            transaction.rollback();
//            return new PlayerOrError("user NOT found (user null)");
//        }
//
//        Player player = results.get(0);
//
//        if(player.getPassword().equals(password)){
//            session.delete(player);
//            transaction.commit();
//        }else{
//            transaction.rollback();
//            return new PlayerOrError("wrong password");
//        }
//
//        if(criteria.list().size() == 0) {
//            return new PlayerOrError("user deleted");
//        }
//        transaction.rollback();
//        return new PlayerOrError("user NOT deleted");
        return null;
    }


//
//    public PlayerOrError updateCredentials(String login, String password, String newLogin, String newPassword){
//        Criteria criteria = session.createCriteria(Player.class);
//        criteria.add(Restrictions.eq("login", login));
//        List<Player> results = criteria.list();
//
//        Transaction transaction = session.getTransaction();
//        if(!transaction.isActive())
//            transaction = session.beginTransaction();
//
//        if(results.size() == 0) {
//            transaction.rollback();
//            return new PlayerOrError("user NOT found (user null)");
//        }
//
//        Player player = results.get(0);
//
//        if(player.getPassword().equals(password)) {
//            if(newLogin != null && newPassword != null){
//                player.setPassword(newPassword);
//                player.setLogin(newLogin);
//                session.saveOrUpdate(player);
//                transaction.commit();
//                return new PlayerOrError("password and login were updated");
//            }
//            if(newPassword != null){
//                player.setPassword(newPassword);
//                session.saveOrUpdate(player);
//                transaction.commit();
//                return new PlayerOrError("password was updated");
//            }
//            if(newLogin != null){
//                player.setLogin(newLogin);
//                session.saveOrUpdate(player);
//                transaction.commit();
//                return new PlayerOrError("login was updated");
//            }
//        }else{
//            transaction.rollback();
//            return new PlayerOrError("user NOT found (password not equal)");
//        }
//        return new PlayerOrError("something went wrong");
//    }







}
