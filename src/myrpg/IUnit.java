package myrpg;

import myrpg.classes.IClass;
import myrpg.effects.Effect;
import myrpg.races.IRace;

import java.util.List;

//Each unit should implement IClass
public interface IUnit {
    //getCurrentBuffs();
    //getCurrentDeBuffs();

    int getCurrentHP();
    int getBaseHp();
    void focusTarget(IUnit target);
    void attackTarget();
    int getCurrentAttack(); //including buffs;
    int getCurrentArmor(); //including buffs;
    void receiveDamage(int val);
    void move(int x, int y);
    IRace getRace();
    IClass _getClass();
    boolean isDead();
    void increaseArmor(int val);
    void decreaseArmor(int val);
    List<Effect> getEffectList();
    boolean addEffect(Effect effect);
    boolean dispelEffect(Effect effect);
    boolean isEffectPresent(Effect effect);
}
