import models.DBmodels.*;
import models.DBmodels.Class;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import services.PlayerService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Program{
    static org.hibernate.Session session;

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my_unit");
        EntityManager em = entityManagerFactory.createEntityManager();

        PlayerService ps = new PlayerService(em);
//        ps.register("login", "password");
        ps.deletePlayer("login", "password");
//        ps.updateCredentials("2", "4", "4",null);
//        ps.getToken("login", "password");

    }



    public static void configure(Configuration configuration){
        configuration.addAnnotatedClass(Class.class);
        configuration.addAnnotatedClass(Effect.class);
        configuration.addAnnotatedClass(EffectToItem.class);
//        configuration.addAnnotatedClass(EffectToItemId.class);
        configuration.addAnnotatedClass(SkillToEffect.class);
//        configuration.addAnnotatedClass(EffectToSkillId.class);
//        configuration.addAnnotatedClass(EffectToUnitId.class);
        configuration.addAnnotatedClass(EffectToUnit.class);
        configuration.addAnnotatedClass(EquippedItem.class);
        configuration.addAnnotatedClass(GameCharacter.class);
        configuration.addAnnotatedClass(Inventory.class);
        configuration.addAnnotatedClass(Item.class);
        configuration.addAnnotatedClass(ItemToLocation.class);
//        configuration.addAnnotatedClass(ItemToLocationId.class);
        configuration.addAnnotatedClass(ItemToSlot.class);
//        configuration.addAnnotatedClass(ItemToSlotId.class);
        configuration.addAnnotatedClass(Location.class);
        configuration.addAnnotatedClass(LocationToMap.class);
//        configuration.addAnnotatedClass(LocationToMapId.class);
        configuration.addAnnotatedClass(Map.class);
        configuration.addAnnotatedClass(Mob.class);
        configuration.addAnnotatedClass(Obstacle.class);
        configuration.addAnnotatedClass(ObstacleToLocation.class);
//        configuration.addAnnotatedClass(ObstacleToLocationId.class);
        configuration.addAnnotatedClass(Player.class);
        configuration.addAnnotatedClass(Profile.class);
        configuration.addAnnotatedClass(Race.class);
        configuration.addAnnotatedClass(Skill.class);
        configuration.addAnnotatedClass(SkillToClass.class);
        configuration.addAnnotatedClass(Slot.class);
        configuration.addAnnotatedClass(Unit.class);
        configuration.addAnnotatedClass(UnitToSkill.class);
//        configuration.addAnnotatedClass(UnitToSkillId.class);
//        configuration.addAnnotatedClass(UnitTemplate.class);
    }

}
