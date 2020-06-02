package test.units.inventory;

import myrpg.effects.IEffect;
import myrpg.factories.MonsterFactory;
import myrpg.items.IItem;
import myrpg.items.gear.armor.Armor;
import myrpg.items.gear.armor.ArmorMaterial;
import myrpg.items.gear.armor.ArmorSlots;
import myrpg.items.gear.weapon.Weapon;
import myrpg.items.gear.weapon.WeaponSlots;
import myrpg.items.gear.weapon.onehanded.Sword;
import myrpg.races.Human;
import myrpg.races.IRace;
import myrpg.units.IUnit;
import myrpg.units.Unit;
import myrpg.units.classes.IClass;
import myrpg.units.classes.Warrior;
import myrpg.units.inventory.IInventory;
import myrpg.units.inventory.Inventory;
import myrpg.units.inventory.InventorySorter;

import java.util.ArrayList;
import java.util.List;

public class InventoryTest {

    public static void main(String[] args) {
//        sortByTypeTest();
        createUnitTest();





    }



    public static void createUnitTest(){
        IUnit unit = MonsterFactory.getRandomUnit();
            for (IItem item : unit.getInventory().getInventoryContent()) {
                System.out.println(item.getItemName());
            }
    }


    public static void sortByTypeTest(){
        IItem sword = new Weapon(WeaponSlots.lHand, "lHand", 1, false, new ArrayList<IEffect>());
        IItem sword6 = new Weapon(WeaponSlots.lHand, "lHand", 1, false, new ArrayList<IEffect>());
        IItem sword2 = new Weapon(WeaponSlots.rHand, "rHand", 1, false, new ArrayList<IEffect>());
        IItem sword3 = new Weapon(WeaponSlots.twoHand, "twoHand", 1, false, new ArrayList<IEffect>());

        IItem helm = new Armor(ArmorSlots.head, ArmorMaterial.iron, "head", 1, false, new ArrayList<IEffect>());
        IItem helm2 = new Armor(ArmorSlots.body, ArmorMaterial.iron, "body", 1, false, new ArrayList<IEffect>());
        IItem helm4 = new Armor(ArmorSlots.body, ArmorMaterial.iron, "body", 1, false, new ArrayList<IEffect>());
        IItem helm3 = new Armor(ArmorSlots.boots, ArmorMaterial.iron, "boots", 1, false, new ArrayList<IEffect>());

        IInventory inv = new Inventory(40);
        inv.put(sword);
        inv.put(helm);
        inv.put(helm2);
        inv.put(helm3);
        inv.put(helm4);
        inv.put(sword3);
        inv.put(sword2);
        inv.put(sword6);

        for(IItem item : inv.getInventoryContent()){
            System.out.println(item.getItemName());
        }

        System.out.println("----------------");

        InventorySorter inventorySorter = new InventorySorter(inv.getInventoryContent());

        inventorySorter.sortByItemType();

        for(IItem item : inv.getInventoryContent()){
            System.out.println(item.getItemName());
        }
    }




}
