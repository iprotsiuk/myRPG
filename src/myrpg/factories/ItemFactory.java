package myrpg.factories;

import myrpg.effects.IEffect;
import myrpg.items.IItem;
import myrpg.items.gear.weapon.onehanded.Sword;

import java.util.List;

public class ItemFactory {

    public static IItem getRandomItem(){
        double random = Math.random();
        int level = (int) (Math.random()*100);
        List<IEffect> effects = EffectFactory.createRandomEffects();

        if(random < 0.5)
            return createOneHandedSword("1hsword", level, effects);
        else
            return createTwoHandedSword("2hsword", level, effects);

    }

    private static IItem createOneHandedSword(String swordName, int level, List<IEffect> effects){
        IItem sword = new Sword(swordName, level, false, effects);
        return sword;
    }

    private static IItem createTwoHandedSword(String swordName, int level, List<IEffect> effects){
        IItem sword = new myrpg.items.gear.weapon.twohanded.Sword(swordName, level, false, effects);
        return sword;
    }

}
