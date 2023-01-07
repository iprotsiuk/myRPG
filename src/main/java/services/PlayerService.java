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

public class PlayerService extends Service{

    public PlayerService(EntityManager em) {
        super(em);
    }


    public SuccessOrError register(String login, String password){
        Player player = new Player();
        player.setLogin(login);
        player.setPassword(password);
        player.setToken(TokenGenerator.generateRandomToken_32());
        startTransaction();

        try {
            em.persist(player);
            transaction.commit();
        }catch (ConstraintViolationException e){
            transaction.rollback();
            return new SuccessOrError(e.getMessage());
        }
        return new SuccessOrError(player);
    }

    public SuccessOrError deletePlayer(String login, String password){

        startTransaction();

        CriteriaBuilder uslovie = em.getCriteriaBuilder();
        CriteriaQuery<Player> querry = uslovie.createQuery(Player.class);
        Root<Player> tableName = querry.from(Player.class);
        ParameterExpression<String> uslovieType = uslovie.parameter(String.class);

        querry.select(tableName).where(uslovie.equal(tableName.get("login"), uslovieType));

        TypedQuery<Player> query = em.createQuery(querry);
        query.setParameter(uslovieType, login);
        List<Player> result = query.getResultList();

        if(result.size() == 0) {
            transaction.rollback();
            return new SuccessOrError("user NOT found (user null)");
        }

        Player player = result.get(0);

        if(player.getPassword().equals(password)){
            em.remove(player);
            transaction.commit();
        }else{
            transaction.rollback();
            return new SuccessOrError("wrong password");
        }

        if(query.getResultList().size() == 0) {
            return new SuccessOrError("user deleted");
        }
        transaction.rollback();
        return new SuccessOrError("user NOT deleted");
    }

    public SuccessOrError getPlayerByToken(String token){
        startTransaction();

        CriteriaBuilder uslovie = em.getCriteriaBuilder();
        CriteriaQuery<Player> querry = uslovie.createQuery(Player.class);
        Root<Player> tableName = querry.from(Player.class);
        ParameterExpression<String> uslovieType = uslovie.parameter(String.class);

        querry.select(tableName).where(uslovie.equal(tableName.get("token"), uslovieType));

        TypedQuery<Player> query = em.createQuery(querry);
        query.setParameter(uslovieType, token);
        List<Player> result = query.getResultList();

        if(result.size() == 0) {
            transaction.rollback();
            return new SuccessOrError("error token");
        }
        Player player = result.get(0);
        return new SuccessOrError(player);
    }

    public void updatePlayer(Player player){
        startTransaction();

        em.refresh(player);
        transaction.commit();
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
