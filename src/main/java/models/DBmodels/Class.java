package models.DBmodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Class implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    int stamina;
    int strength;
    int agility;
    int intellect;
    double strMultiplier;
    double intMultiplier;
    double agiMultiplier;
    double staMultiplier;

    public Class() {
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

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public double getStrMultiplier() {
        return strMultiplier;
    }

    public void setStrMultiplier(double strMultiplier) {
        this.strMultiplier = strMultiplier;
    }

    public double getIntMultiplier() {
        return intMultiplier;
    }

    public void setIntMultiplier(double intMultiplier) {
        this.intMultiplier = intMultiplier;
    }

    public double getAgiMultiplier() {
        return agiMultiplier;
    }

    public void setAgiMultiplier(double agiMultiplier) {
        this.agiMultiplier = agiMultiplier;
    }

    public double getStaMultiplier() {
        return staMultiplier;
    }

    public void setStaMultiplier(double staMultiplier) {
        this.staMultiplier = staMultiplier;
    }


}
