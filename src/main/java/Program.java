import models.DBmodels.*;
import models.DBmodels.Class;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.LinkedList;

public class Program{
    static org.hibernate.Session session;

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
///**
        configure(configuration);
// **/
        configuration.configure("hibernate.cfg.xml");

        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
        session = sessionFactory.openSession();

        Unit unit = new Unit();
        unit.setCurrentHp(100);
        unit.setCurrentMana(55);
        unit.setExp(103123);

        Class _class = new Class();
        _class.setName("archer");
        _class.setAgility(15);
        _class.setStrength(10);
        _class.setIntellect(10);
        _class.setStamina(12);

        Race race = new Race();
        race.setName("human");
        race.setAgiMultiplier(1);
        race.setIntMultiplier(3);
        race.setStrMultiplier(3);
        race.setStaMultiplier(3);
//        race.setId(1);

//        unit.setId(1);




        Skill skill = new Skill();
        Skill skill2 = new Skill();
        skill.setLevel(3);
        skill2.setLevel(1);
        skill.setName("testskill");
        skill2.setName("testskill2");

        Effect effect = new Effect();
        Effect effect2 = new Effect();
        Effect effect3 = new Effect();
        Effect effect4 = new Effect();
        effect.setName("testEffect1");
        effect2.setName("testEffect2");
        effect3.setName("testEffect3");
        effect4.setName("testEffect4");

        LinkedList<Effect> listEffects = new LinkedList<>();
        listEffects.add(effect);
        listEffects.add(effect2);
        listEffects.add(effect3);
        listEffects.add(effect4);




        HashSet<Skill> skillset = new HashSet<>();
        skillset.add(skill);
        skillset.add(skill2);
        race.setRaceSkills(skillset);

        EffectToSkill ets = new EffectToSkill(skill, effect);
        EffectToSkill ets2 = new EffectToSkill(skill, effect2);
        EffectToSkill ets3 = new EffectToSkill(skill, effect3);


        Transaction transaction = session.getTransaction();
        if(!transaction.isActive())
            transaction = session.beginTransaction();

        try {
//            session.save(ets);
//            session.save(ets2);
//            session.save(ets3);

//            session.save(race);
//            session.save(_class);
//            session.save(skill);
//
//            for(Effect e : listEffects){
//                if(!transaction.isActive())
//                    transaction = session.beginTransaction();
//                try {
//                    session.save(e);
//                    transaction.commit();
//                }catch (Exception ex){
//                    transaction.rollback();
//                }

                session.save(skill);

                session.save(effect);
                session.save(effect2);
                session.save(effect3);

                session.save(skill2);


                session.save(ets);
                session.save(ets2);
                session.save(ets3);

            transaction.commit();

//            session.save(unit);

//            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }

    session.close();
    }



    public static void configure(Configuration configuration){
        configuration.addAnnotatedClass(Class.class);
        configuration.addAnnotatedClass(Effect.class);
        configuration.addAnnotatedClass(EffectToItem.class);
        configuration.addAnnotatedClass(EffectToItemId.class);
        configuration.addAnnotatedClass(EffectToSkill.class);
        configuration.addAnnotatedClass(EffectToSkillId.class);
        configuration.addAnnotatedClass(EffectToUnitId.class);
        configuration.addAnnotatedClass(EffectToUnit.class);
        configuration.addAnnotatedClass(EquippedItem.class);
        configuration.addAnnotatedClass(gameCharacter.class);
        configuration.addAnnotatedClass(Inventory.class);
        configuration.addAnnotatedClass(Item.class);
        configuration.addAnnotatedClass(ItemToLocation.class);
        configuration.addAnnotatedClass(ItemToLocationId.class);
        configuration.addAnnotatedClass(ItemToSlot.class);
        configuration.addAnnotatedClass(ItemToSlotId.class);
        configuration.addAnnotatedClass(Location.class);
        configuration.addAnnotatedClass(LocationToMap.class);
        configuration.addAnnotatedClass(LocationToMapId.class);
        configuration.addAnnotatedClass(Map.class);
        configuration.addAnnotatedClass(Mob.class);
        configuration.addAnnotatedClass(Obstacle.class);
        configuration.addAnnotatedClass(ObstacleToLocation.class);
        configuration.addAnnotatedClass(ObstacleToLocationId.class);
        configuration.addAnnotatedClass(Player.class);
        configuration.addAnnotatedClass(Profile.class);
        configuration.addAnnotatedClass(Race.class);
        configuration.addAnnotatedClass(Skill.class);
        configuration.addAnnotatedClass(SkillToClass.class);
        configuration.addAnnotatedClass(Slot.class);
        configuration.addAnnotatedClass(Unit.class);
        configuration.addAnnotatedClass(UnitToSkill.class);
        configuration.addAnnotatedClass(UnitToSkillId.class);
        configuration.addAnnotatedClass(UnitTemplate.class);
    }

}
