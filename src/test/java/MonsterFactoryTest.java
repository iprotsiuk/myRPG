import myrpg.factories.MonsterFactory;
import myrpg.items.IItem;
import myrpg.items.gear.GearSlotType;
import myrpg.units.IUnit;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MonsterFactoryTest {


    @Test
    public void createUnitTest(){
        List<IUnit> units = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            IUnit unit = MonsterFactory.getRandomUnit();
            units.add(unit);
        }

        for(IUnit unit : units){
            Assert.assertNotNull(unit.getInventory());
            Assert.assertNotNull(unit.getGear());
        }


    }
}
