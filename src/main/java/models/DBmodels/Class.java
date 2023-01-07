package models.DBmodels;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Class implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    @Column(unique = true)
    String name;
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
