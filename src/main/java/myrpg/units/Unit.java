package myrpg.units;

import myrpg.items.gear.IGear;
import myrpg.units.classes.IClass;
import myrpg.effects.Effect;
import myrpg.races.IRace;
import myrpg.units.inventory.IInventory;

import java.util.ArrayList;
import java.util.List;

public class Unit implements IUnit{

    IGear gear;
    IInventory inventory;

    int expCost;

    int level;
    int speed;
    int damage;
    IRace _race;
    IClass _class;
    IUnit focusedTarget;
    int baseHp;
    int magicalResistance;
    int currentHp;
    int currentArmor = 0;
    int currentMagicalResistance = 0;
    List<Effect> effectList = new ArrayList<Effect>();

   boolean isDead = false;
    static  int countCreate = 0;
    static int countDead = 0;

    public Unit(IRace race, IClass _class, int expCost, int level) {
        this._race = race;
        this._class = _class;
        this.baseHp = _class.getBaseHp()+_race.getBonusHp();
        this.currentHp = this.baseHp;
        this.expCost = expCost;
        this.level = level;
        countCreate++;
    }


    @Override
    public IRace getRace() {
        return _race;
    }

    @Override
    public IClass _getClass() {
        return this._class;
    }

    public static  int getCountCreate()
    {
        return countCreate;
    }

    public static int getCountDead()
    {
        return countDead;
    }

    public int getBaseHp() {
        return baseHp;
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public int getCurrentHP() {
        return currentHp;
    }

    @Override
    public int getCurrentMagicalResistance() {
        return currentMagicalResistance + _class.getBaseMagicalResistance();
    }


    public boolean isDead(){
        return isDead;
    }

    @Override
    public void increaseArmor(int val) {
        currentArmor+=val;
    }

    @Override
    public void decreaseArmor(int val) {
        currentArmor-=val;
    }

    @Override
    public void setFocusTarget(IUnit target) {
        this.focusedTarget = target;
    }

    @Override
    public void attackTarget() {
        System.out.println(this.getRace().getRaceName() + " " + this._getClass().getClassName() + " attacks " + focusedTarget.getRace().getRaceName()+ " " + focusedTarget._getClass().getClassName());
        focusedTarget.receiveDamage(getCurrentAttack());
    }

    //TODO calculate percents instead of integers
    @Override
    public int getCurrentAttack() {
        return _class.getBaseAttack() + (_race.getBonusDamagePercent(_class.getAttackType()));
    }

    @Override
    public int getCurrentArmor() {
        return currentArmor + _class.getBaseArmor();
    }

    //TODO add formula to catch < 0 damage
    public void receiveDamage(int val)
    {
        currentHp -= val - getCurrentArmor() ;
        if(currentHp <= 0)
        {
            isDead = true;
            countDead ++;
        }
    }




    @Override
    public List<Effect> getEffectList() {
        return null;
    }

    @Override
    public boolean addEffect(Effect effect) {
        effectList.add(effect);
        return true;
    }




    @Override
    public boolean dispelEffect(Effect effect) {
        if(effectList.contains(effect)) {
            effectList.remove(effect);
            return true;
        }
        return false;
    }

    @Override
    public boolean isEffectPresent(Effect effect) {
        return effectList.contains(effect);
    }

    @Override
    public boolean increaseSpeed(int val) {
        this.speed += val;
        return false;
    }

    @Override
    public boolean decreaseSpeed(int val) {
        this.speed -= val;
        return true;
    }

    @Override
    public boolean increaseMagicalResistance(int val) {
        this.magicalResistance += val;
        return true;
    }

    @Override
    public boolean decreaseMagicalResistance(int val) {
        this.magicalResistance -= val;
        return true;
    }

    public IGear getGear() {
        return gear;
    }


    @Override
    public void setGear(IGear gear) {
        this.gear = gear;
    }

    @Override
    public void setInventory(IInventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public IInventory getInventory() {
        return inventory;
    }

    @Override
    public int getExpCost() {
        return this.expCost;
    }

    @Override
    public int getLevel() {
        return this.level;
    }


    @Override
    public int compareTo(IUnit unit) {
        return Integer.compare(this.level, unit.getLevel());
    }
}
