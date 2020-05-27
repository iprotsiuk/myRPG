package myrpg.units;

import myrpg.items.gear.IGear;
import myrpg.units.classes.IClass;
import myrpg.effects.Effect;
import myrpg.races.IRace;
import myrpg.units.inventory.IInventory;

import java.util.List;

//Each unit should implement IClass
public interface IUnit {
    //getCurrentBuffs();
    //getCurrentDeBuffs();

    int getCurrentHP();
    int getCurrentMagicalResistance();
    int getBaseHp();
    int getSpeed();
    void focusTarget(IUnit target);
    void attackTarget();
    int getCurrentAttack(); //including buffs;
    int getCurrentArmor(); //including buffs;
    void receiveDamage(int val);
    IRace getRace();
    IClass _getClass();
    boolean isDead();
    void increaseArmor(int val);
    void decreaseArmor(int val);
    List<Effect> getEffectList();
    boolean addEffect(Effect effect);
    boolean dispelEffect(Effect effect);
    boolean isEffectPresent(Effect effect);
    boolean increaseSpeed(int val);
    boolean decreaseSpeed(int val);
    boolean increaseMagicalResistance(int val);
    boolean decreaseMagicalResistance(int val);
    IGear getGear();
    void setGear(IGear gear);
    void setInventory(IInventory inventory);
    IInventory getInventory();
    int getExpCost();
    int getLevel();


    }
