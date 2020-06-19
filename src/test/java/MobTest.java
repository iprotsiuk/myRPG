import myrpg.map.Map;
import myrpg.map.Point;
import myrpg.races.Human;
import myrpg.races.IRace;
import myrpg.units.Actor;
import myrpg.units.IUnit;
import myrpg.units.Mob;
import myrpg.units.MovementController;
import myrpg.units.classes.Archer;
import myrpg.units.classes.IClass;
import org.junit.Test;

import java.util.List;

public class MobTest {
    Map map = new Map(15, 15);
    MovementController mc = new MovementController(map);
    IRace race = new Human();
    IClass _class = new Archer();

    Mob mob = new Mob(race, _class, 55, 10, mc, 2);
    IUnit actor = new Actor(race, _class, 5, mc);

    // movementController.getReachableLocations(this, patrolRange, speed);
    @Test
    public void test(){
        map.generateEmptyMap();
        map.addUnit(mob, new Point(7,7));
        List<Point> reachableLocations = mc.getReachableLocations(mob, 2, 3);
        mob.setReachableLocations(reachableLocations);

        System.out.println(mob.getReachableLocations());

        System.out.println(mob.roam());
    }

}
