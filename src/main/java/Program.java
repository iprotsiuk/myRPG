import models.DBmodels.*;
import models.DBmodels.Class;
import org.hibernate.cfg.Configuration;
import services.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Program{
    static org.hibernate.Session session;

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my_unit");
        EntityManager em = entityManagerFactory.createEntityManager();
        PlayerService ps = new PlayerService(em);
        CharacterService cs = new CharacterService(em);
        RaceService rs = new RaceService(em);
        ClassService _cs = new ClassService(em);

        ServiceManager.setPlayerService(ps);
        ServiceManager.setCharacterService(cs);
        ServiceManager.setClassService(_cs);
        ServiceManager.setRaceService(rs);




//        ps.register("login", "password");
//        ps.deletePlayer("login", "password");
//        ps.updateCredentials("2", "4", "4",null);
//        ps.getToken("login", "password");
        int[] arr = {5, 3,-2,-1, 4, 6, 6, -3, -4, -6, -4};
        int[] arr2 = {3,2,1};
//        System.out.println(test2(arr));
//        System.out.println(test2(arr2));

        test2();

    }



    private static void test2() {
        Unit unit = new Unit();
//        System.out.println(unit);


//        hm.put(b, "c");
//        hm.put(c, "c");
//        hm.put(a, "a");
//        hm.put(b, "b");
//        hm.put(c, "c");
//        hm.put(a, "c");
//        hm.put(b, "c");
//        hm.put(c, "c");

    }

    private static boolean test(int[] arr){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum;
        boolean ans = false;
        for(int i = 0; i < arr.length-1; i++){
            sum = arr[i];
            for(int j = i+1; j < arr.length; j++){
                sum+=arr[j];
                if(sum == 0){
                    ans = true;
                }
            }
        }
        return ans;
    }

    private static List test2(int[] arr){
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum+=arr[i];
            list.add(sum);
        }
        return list;
    }



    public static void configure(Configuration configuration){
        configuration.addAnnotatedClass(Class.class);
        configuration.addAnnotatedClass(Effect.class);
        configuration.addAnnotatedClass(EffectToItem.class);
        configuration.addAnnotatedClass(SkillToEffect.class);
        configuration.addAnnotatedClass(EffectToUnit.class);
        configuration.addAnnotatedClass(EquippedItem.class);
        configuration.addAnnotatedClass(GameCharacter.class);
        configuration.addAnnotatedClass(Inventory.class);
        configuration.addAnnotatedClass(Item.class);
        configuration.addAnnotatedClass(ItemToLocation.class);
        configuration.addAnnotatedClass(ItemToSlot.class);
        configuration.addAnnotatedClass(Location.class);
        configuration.addAnnotatedClass(LocationToMap.class);
        configuration.addAnnotatedClass(Map.class);
        configuration.addAnnotatedClass(Mob.class);
        configuration.addAnnotatedClass(Obstacle.class);
        configuration.addAnnotatedClass(ObstacleToLocation.class);
        configuration.addAnnotatedClass(Player.class);
        configuration.addAnnotatedClass(Profile.class);
        configuration.addAnnotatedClass(Race.class);
        configuration.addAnnotatedClass(Skill.class);
        configuration.addAnnotatedClass(SkillToClass.class);
        configuration.addAnnotatedClass(Slot.class);
        configuration.addAnnotatedClass(Unit.class);
        configuration.addAnnotatedClass(UnitToSkill.class);
    }

}
