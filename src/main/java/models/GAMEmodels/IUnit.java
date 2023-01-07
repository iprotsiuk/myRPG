package models.GAMEmodels;



import models.GAMEmodels._classes.IClass;
import models.GAMEmodels._races.IRace;
import models.GAMEmodels.effects.Effect;

import java.util.List;

//Each unit should implement IClass
public interface IUnit extends Comparable<IUnit> {
    //getCurrentBuffs();
    //getCurrentDeBuffs();

    int getCurrentHP();
    int getCurrentMagicalResistance();
    int getBaseHp();
    int getMovementDistance();
    void setFocusTarget(IUnit target);
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
//    IGear getGear();
//    void setGear(IGear gear);
//    void setInventory(IInventory inventory);
//    IInventory getInventory();
    long getExpCost();
    int getLevel();
//    default IMove getMovable() {
//        return null;
//    }

}
