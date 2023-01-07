package services;

import Factory.CharacterFactory;
import models.DBmodels.Class;
import models.DBmodels.GameCharacter;
import models.DBmodels.Player;
import models.DBmodels.Race;

import javax.persistence.EntityManager;

public class CharacterService extends Service {

    public CharacterService(EntityManager em) {
        super(em);
    }


    public SuccessOrError create(RequestJson requestJson) {
        SuccessOrError successOrError = ServiceManager.getPlayerService().getPlayerByToken(requestJson.getToken());

        if (successOrError.getObject() == null)
            return new SuccessOrError(successOrError.getError());

        Player player = (Player) successOrError.getObject();

        startTransaction();
        try {
            Race race = ServiceManager.getRaceService().getRace(requestJson.getRace());
            Class _class = ServiceManager.getClassService().getClass(requestJson.get_class());
            GameCharacter character = CharacterFactory.createGameCharacter(race, _class, requestJson.getName());
            player.addCharacter(character);
            em.persist(character);
            em.refresh(player);
            transaction.commit();
            return new SuccessOrError(character);
        } catch (Exception e) {
            transaction.rollback();
            return new SuccessOrError(e.getMessage());
        }
    }
}
