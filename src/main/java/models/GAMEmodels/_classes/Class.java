package models.GAMEmodels._classes;

import models.GAMEmodels.Stat;

public class Class implements IClass{

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

    public void setId(int id) {
        this.id = id;
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

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStat(Stat stat) {
        switch (stat){
            case Strength:
                return this.strength;
            case Agility:
                return this.agility;
            case Stamina:
                return this.stamina;
            case Intellect:
                return this.intellect;
        }
        return -1;
    }

    @Override
    public double getStatMultiplier(Stat stat) {
        switch (stat){
            case Strength:
                return this.strMultiplier;
            case Agility:
                return this.agiMultiplier;
            case Stamina:
                return this.staMultiplier;
            case Intellect:
                return this.intMultiplier;
        }
        return -1.0;
    }


}
