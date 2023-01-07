package models.DBmodels;

import models.GAMEmodels.effects.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Effect  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true)
    String name;

    EffectType effectType;
    boolean magicalEffect;
    int amount; // amount of heal/damage/whatever
    TargetEffect target; // -1 self; 0 area; 1 target;

    public Effect() {
    }

    public boolean isMagicalEffect() {
        return magicalEffect;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public TargetEffect getTarget() {
        return target;
    }

    public void setTarget(TargetEffect target) {
        this.target = target;
    }

    public boolean getMagicalEffect() {

        return magicalEffect;
    }

    public void setMagicalEffect(boolean magicalEffect) {
        this.magicalEffect = magicalEffect;
    }

    public EffectType getEffectType() {
        return effectType;
    }

    public void setEffectType(EffectType effectType) {
        this.effectType = effectType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
