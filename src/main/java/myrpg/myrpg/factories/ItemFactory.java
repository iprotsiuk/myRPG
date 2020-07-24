package myrpg.factories;

import myrpg.effects.IEffect;
import myrpg.items.IItem;
import myrpg.items.gear.armor.ArmorMaterial;
import myrpg.items.gear.armor.body.Body;
import myrpg.items.gear.armor.feet.Boots;
import myrpg.items.gear.armor.head.Helm;
import myrpg.items.gear.weapon.onehanded.Sword;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemFactory {

    public static IItem getRandomItem(){
        double random = Math.random();
        int level = (int) (Math.random()*100);
        List<IEffect> effects = EffectFactory.createRandomEffects();

        if(random < 0.2)
            return createOneHandedSword("1hsword", level, effects);
        else if(random < 0.4)
            return createTwoHandedSword("2hsword", level, effects);
        else if(random < 0.6)
            return createHelmet(ArmorMaterial.iron, "helmet", level, effects);
        else if(random < 0.8)
            return createBody(ArmorMaterial.iron, "body", level, effects);
        else
            return createBoots(ArmorMaterial.iron, "boots", level, effects);
    }

    public static List<IItem> getListRandomItems(){
        Random rand = new Random();
        List<IItem> inventoryList = new ArrayList<>();
        int random = rand.nextInt(5);

        for(int i = 0; i < random; i++){
            IItem item = ItemFactory.getRandomItem();
            inventoryList.add(item);
        }
        return inventoryList;
    }

    private static IItem createOneHandedSword(String swordName, int level, List<IEffect> effects){
        IItem sword = new Sword(swordName, level, effects);
        return sword;
    }

    private static IItem createTwoHandedSword(String swordName, int level, List<IEffect> effects){
        IItem sword = new myrpg.items.gear.weapon.twohanded.Sword(swordName, level, effects);
        return sword;
    }

    private static IItem createHelmet(ArmorMaterial armorMaterial,String helmName, int level, List<IEffect> effects){
        IItem helm = new Helm(armorMaterial, helmName, level, effects);
        return helm;
    }

    private static IItem createBody(ArmorMaterial armorMaterial,String bodyName, int level, List<IEffect> effects){
        IItem bod = new Body(armorMaterial, bodyName, level, effects);
        return bod;
    }

    private static IItem createBoots(ArmorMaterial armorMaterial,String bootsName, int level, List<IEffect> effects){
        IItem boots = new Boots(armorMaterial, bootsName, level, effects);
        return boots;
    }
}
