import myrpg.effects.IEffect;
import myrpg.items.IItem;
import myrpg.items.gear.Gear;
import myrpg.items.gear.GearSlotType;
import myrpg.items.gear.IGear;
import myrpg.items.gear.armor.ArmorMaterial;
import myrpg.items.gear.armor.body.Body;
import myrpg.items.gear.armor.feet.Boots;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class GearTest {

    IGear gear = new Gear();

    IItem body = new Body(ArmorMaterial.iron, "body", 1, new ArrayList<IEffect>());
    IItem body2 = new Body(ArmorMaterial.iron, "body2", 1, new ArrayList<IEffect>());
    IItem boots = new Boots(ArmorMaterial.iron, "boots", 1, new ArrayList<IEffect>());
    IItem boots2 = new Boots(ArmorMaterial.iron, "boots2", 1, new ArrayList<IEffect>());


    int i = 0;

    Iterator hmIterator;
    Map<GearSlotType, IItem> gearMap;


     List<IItem> items = new LinkedList<>();
     List<IItem> itemsBody = new LinkedList<>();
     List<IItem> itemsBoots = new LinkedList<>();
    {
        items.add(body);
        items.add(body2);
        items.add(boots);
        items.add(boots2);
        itemsBoots.add(boots2);
        itemsBoots.add(boots);
        itemsBody.add(body);
        itemsBody.add(body2);
    }

    @Test
    public void equipTwoBodyTest(){
        gearMap = gear.getGearList();

        Assert.assertEquals(gearMap.size(), 0);

        gear.equipAllInList(itemsBody);

        Assert.assertTrue(gear.isSlotBusy(GearSlotType.body));
        Assert.assertFalse(gear.isSlotBusy(GearSlotType.boots));


        Iterator hmIterator = gearMap.entrySet().iterator();

        while (hmIterator.hasNext()){
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            IItem item = (IItem) mapElement.getValue();
            Assert.assertEquals(GearSlotType.body, item.getPossibleSlots().get(0));
        }

    }
    @Test
    public void equipTwoBootTest(){
        gearMap = gear.getGearList();

        Assert.assertEquals(gearMap.size(), 0);

        gear.equipAllInList(itemsBoots);

        Assert.assertFalse(gear.isSlotBusy(GearSlotType.body));
        Assert.assertTrue(gear.isSlotBusy(GearSlotType.boots));


        Iterator hmIterator = gearMap.entrySet().iterator();

        while (hmIterator.hasNext()){
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            IItem item = (IItem) mapElement.getValue();
            Assert.assertEquals(GearSlotType.boots, item.getPossibleSlots().get(0));
        }

    }

    @Test
    public void equipAllTest(){
        gearMap = gear.getGearList();

        Assert.assertEquals(gearMap.size(), 0);

        gear.equipAllInList(items);

        Assert.assertTrue(gear.isSlotBusy(GearSlotType.body));
        Assert.assertTrue(gear.isSlotBusy(GearSlotType.boots));


        Iterator hmIterator = gearMap.entrySet().iterator();

        while (hmIterator.hasNext()){
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            GearSlotType slotType = (GearSlotType) mapElement.getKey();
            IItem item = (IItem) mapElement.getValue();
            Assert.assertEquals(slotType, item.getPossibleSlots().get(0));
        }

    }


    @Test
    public void EquipBodyTest(){
        gear.equip(GearSlotType.body, boots);
        Assert.assertFalse(gear.isSlotBusy(GearSlotType.body));

        gear.equip(GearSlotType.body, body);
        Assert.assertTrue(gear.isSlotBusy(GearSlotType.body));
    }

    @Test
    public void EquipBootsTest(){
        gear.equip(GearSlotType.boots, body);
        Assert.assertFalse(gear.isSlotBusy(GearSlotType.body));

        gear.equip(GearSlotType.boots, boots);
        Assert.assertTrue(gear.isSlotBusy(GearSlotType.boots));
    }


}
