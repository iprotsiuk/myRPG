import myrpg.effects.IEffect;
import myrpg.items.IItem;
import myrpg.items.gear.armor.ArmorMaterial;
import myrpg.items.gear.armor.body.Body;
import myrpg.items.gear.armor.feet.Boots;
import myrpg.items.gear.armor.head.Helm;
import myrpg.items.gear.weapon.onehanded.Dagger;
import myrpg.items.gear.weapon.onehanded.Sword;
import myrpg.items.gear.weapon.onehanded.Wand;
import myrpg.units.inventory.IInventory;
import myrpg.units.inventory.Inventory;
import myrpg.units.inventory.InventorySorter;
import org.junit.Test;

import java.util.ArrayList;

public class InventoryTest {


    @Test
    public void sortByTypeTest(){
        IItem sword = new Sword("lHand", 1, new ArrayList<IEffect>());
        IItem sword6 = new Dagger("lHand", 1, new ArrayList<IEffect>());
        IItem sword2 = new Wand("rHand", 1, new ArrayList<IEffect>());
        IItem sword3 = new myrpg.items.gear.weapon.twohanded.Sword("twoHand", 1, new ArrayList<IEffect>());

        IItem helm = new Helm(ArmorMaterial.iron, "head", 1, new ArrayList<IEffect>());
        IItem helm2 = new Body(ArmorMaterial.iron, "body", 1, new ArrayList<IEffect>());
        IItem helm4 = new Body(ArmorMaterial.iron, "body", 1, new ArrayList<IEffect>());
        IItem helm3 = new Boots(ArmorMaterial.iron, "boots", 1, new ArrayList<IEffect>());

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

        System.out.println("----------------------------------------------------------");

        InventorySorter inventorySorter = new InventorySorter(inv.getInventoryContent());

        inventorySorter.sortByItemType();

        for(IItem item : inv.getInventoryContent()){
            System.out.println(item.getItemName());
        }
    }




}
