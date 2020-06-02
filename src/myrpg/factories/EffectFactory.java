package myrpg.factories;

import myrpg.effects.BonusArmor;
import myrpg.effects.BonusSpeed;
import myrpg.effects.IEffect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class EffectFactory {
    static List<IEffect> effects = new ArrayList<>();

    static {
        for(int i = 1; i < 21; i++){
            effects.add(new BonusArmor(i));
            effects.add(new BonusSpeed(i));
        }
    }

    public static List<IEffect> createRandomEffects(){
        Random random = new Random();
        List<IEffect> randomEffects = new ArrayList<>();
        int randomForAmountOfEffects = random.nextInt(100);
        int randomEffectIndex = random.nextInt(effects.size());
        int amount;

        if(randomForAmountOfEffects < 50)
            amount = 1;
        else if (randomForAmountOfEffects < 75 )
            amount = 2;
        else if (randomForAmountOfEffects < 98)
            amount = 3;
        else
            amount = 4;


        for(int i = 0; i < amount; ){
            if(!randomEffects.contains(effects.get(randomEffectIndex))) {
                randomEffects.add(effects.get(i));
                i++;
            }
            randomEffectIndex = random.nextInt(effects.size());

        }

        return randomEffects;
    }


}
