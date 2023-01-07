package models.GAMEmodels._classes;

import models.GAMEmodels.Stat;

public class Class implements IClass{

    int id;

    String name;

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
