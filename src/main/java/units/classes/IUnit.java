package units.classes;


import models.GAMEmodels.Stat;
import models.GAMEmodels.StatDependency;

//Each unit should implement IClass
public interface IUnit extends Comparable<IUnit> {

    //    int getCurrentMagicalResistance();
    //getCurrentBuffs();
    //getCurrentDeBuffs();


    //    int getBaseHp();
    int getCurrentHP();
    int getMaxHp();

    int getCurrentMana();
    int getMaxMana();

    int getLevel();
    long getCurrentExp();
    long getExpCost();

    int getStat(Stat stat, StatDependency statDependency);




//    int getMovementDistance();
//    void setFocusTarget(myrpg.units.IUnit target);
//    void attackTarget();
//    int getCurrentAttack(); //including buffs;
//    int getCurrentArmor(); //including buffs;
//    void receiveDamage(int val);
//    IRace getRace();
//    IClass _getClass();
//    boolean isDead();
//    void increaseArmor(int val);
//    void decreaseArmor(int val);
//    List<Effect> getEffectList();
//    boolean addEffect(Effect effect);
//    boolean dispelEffect(Effect effect);
//    boolean isEffectPresent(Effect effect);
//    boolean increaseSpeed(int val);
//    boolean decreaseSpeed(int val);
//    boolean increaseMagicalResistance(int val);
//    boolean decreaseMagicalResistance(int val);
//    IGear getGear();
//    void setGear(IGear gear);
//    void setInventory(IInventory inventory);
//    IInventory getInventory();
//
//    default IMove getMovable() {
//        return null;
//    }

}
