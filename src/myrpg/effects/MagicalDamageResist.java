package myrpg.effects;

import myrpg.units.IUnit;

public class MagicalDamageResist extends Effect {
    int resist;
    static int multiplier = 2;

    public MagicalDamageResist(int level) {
        super("Magical Damage Resist", "provides magical damage resistance " + level*multiplier, level);
        this.resist = level*multiplier;
    }

    @Override
    public boolean addEffect(IUnit unit) {
        unit.addEffect(this);
        unit.increaseMagicalResistance(resist);
        return true;
    }

    @Override
    public boolean dispelEffect(IUnit unit) {
        if(unit.isEffectPresent(this)) {
            unit.dispelEffect(this);
            unit.decreaseMagicalResistance(resist);
            return true;
        }
        return false;
    }
}
