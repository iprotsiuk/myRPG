package myrpg.factories;

import myrpg.items.IItem;
import myrpg.items.gear.Gear;
import myrpg.items.gear.IGear;
import myrpg.races.IRace;
import myrpg.races.Undead;
import myrpg.units.IUnit;
import myrpg.units.Unit;
import myrpg.units.classes.Archer;
import myrpg.units.classes.IClass;
import myrpg.units.classes.Warrior;
import myrpg.units.inventory.IInventory;
import myrpg.units.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonsterFactory {

    private static IUnit createUnit(IRace _race, IClass _class, int expCost, int level, List<IItem> inventoryList){
        IUnit unit = new Unit(_race, _class, expCost, level);
        IGear gearOnUnit = new Gear();
        IInventory inventoryOnUnit = new Inventory(999);


        if(inventoryList != null && inventoryList.size() > 0 ) {
            inventoryOnUnit.putAllInList(gearOnUnit.equipAllInList(inventoryList));
            unit.setGear(gearOnUnit);
        }

        if(inventoryOnUnit.getEmptySpace() != inventoryOnUnit.getTotalSpace())
            unit.setInventory(inventoryOnUnit);

        return unit;
    }

    static IUnit createUndeadArcher(int level,  List<IItem> inventoryList){
        IRace race = new Undead();
        IClass _class = new Archer();
        return createUnit(race, _class, 50, level, inventoryList);
    }

    static IUnit createUndeadWarrior(int level, List<IItem> inventoryList){
        IRace race = new Undead();
        IClass _class = new Warrior();
        return createUnit(race, _class, 30, level, inventoryList);
    }

    public static IUnit getRandomUnit(){
        double randomNumber = Math.random();
        int level = (int) (Math.random() * 100);
        if(randomNumber < 0.7) {
            return createUndeadWarrior(level, createInventoryList());
        }
        return createUndeadArcher(level, createInventoryList());

    }

    private static List<IItem> createInventoryList(){
        Random rand = new Random();
        List<IItem> inventoryList = new ArrayList<>();
        int random = rand.nextInt(10);

        for(int i = 1; i < random; i++){
            inventoryList.add(ItemFactory.getRandomItem());
        }
        System.out.println(inventoryList);
        return inventoryList;
    }


}
