import myrpg.map.Map;
import myrpg.map.Point;
import myrpg.races.Human;
import myrpg.races.IRace;
import myrpg.units.*;
import myrpg.units.classes.Archer;
import myrpg.units.classes.IClass;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class MobTest {
    Map map = new Map(15, 15);
    MovementController mc = new MovementController(map);
    IRace race = new Human();
    IClass _class = new Archer();

    Mob mob = new Mob(race, _class, 55, 10, mc, 2, 6);
    Mob mobNoPatrolRange = new Mob(race, _class, 55, 10, mc, 0, 0);
    IUnit actor = new Actor(race, _class, 5, mc);

    // movementController.getReachableLocations(this, patrolRange, speed);
    @Test
    public void getReachableLocationsTest(){
        map.generateEmptyMap();
        map.addUnit(mob, new Point(7,7));

        List<Point> reachableLocations = mc.getReachableLocations(mob, 2, mob.getMovementDistance());
        mob.setReachableLocations(reachableLocations);

        String[] arr = "[5:7],[6:6],[6:7],[6:8],[7:5],[7:6],[7:7],[7:8],[7:9],[8:6],[8:7],[8:8],[9:7]".split(",");

        List<Point> mobReachableLocations = mob.getReachableLocations();

        for(int i = 0; i < arr.length; i++){
            Assert.assertEquals(mobReachableLocations.get(i).toString(), arr[i]);
        }
    }

    @Test
    public void getCurrentPositionTest(){
        map.generateEmptyMap();
        Point point = new Point (7,7);
        map.addUnit(mob, point);
        Assert.assertEquals(mob.getCurrentPosition().toString(), point.toString());
    }

    @Test
    public void moveToAttackRangeTest(){
        map.generateEmptyMap();
        Point point1 = new Point (7,7);
        Point point2 = new Point (10,7);
        map.addUnit(mobNoPatrolRange, point2);
        map.addUnit(mob, point1);

        List<Point> path = mob.moveToAttackRange(mobNoPatrolRange.getUnit());

        List<Point> expectedPath = new LinkedList<>();
        expectedPath.add(new Point(8, 7));
        expectedPath.add(new Point(9, 7));

        Assert.assertEquals(path, expectedPath);

    }

}
