package myrpg;

import myrpg.classes.IClass;
import myrpg.classes.IMove;
import myrpg.effects.Effect;
import myrpg.races.IRace;

import java.util.ArrayList;
import java.util.List;

public class Unit implements IUnit{
    int speed;
    int damage;
    IRace _race;
    IClass _class;
    IMove move;
    IUnit focusedTarget;
    int baseHp;
    int currentHp;
    int currentArmor = 0;
    List<Effect> effectList = new ArrayList<Effect>();


    boolean isDead = false;
    static  int countCreate = 0;
    static int countDead = 0;

    public Unit(IRace race, IClass _class) {
        this._race = race;
        this._class = _class;
        this.baseHp = _class.getBaseHp()+_race.getBonusHp();
        this.currentHp = this.baseHp;
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
    public int getCurrentHP() {
        return currentHp;
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
    public void focusTarget(IUnit target) {
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
        return _class.getBaseAttack()+(_race.getBonusDamagePercent(_class.getAttackType()));
    }

    @Override
    public int getCurrentArmor() {
        return currentArmor+_class.getBaseArmor();
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
    public void move(int x, int y) {
        move.move(x, y);
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
}
