package myrpg.effects;

public abstract class Effect implements IEffect {
    String name;
    String description;
    int level;

    public Effect(String name, String description, int level) {
        this.name = name;
        this.description = description;
        this.level = level;
    }

    @Override
    public String getEffectName() {
        return this.name;
    }

    @Override
    public String getEffectDescription() {
        return this.description;
    }

    @Override
    public int getEffectLevel() {
        return level;
    }
}
