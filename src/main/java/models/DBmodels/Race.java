package models.DBmodels;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToMany
    Set<Skill> raceSkills;

    @Column(unique = true)
    String name;
    double strMultiplier;
    double agiMultiplier;
    double intMultiplier;
    double staMultiplier;

    public Race() {
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

    public double getAgiMultiplier() {
        return agiMultiplier;
    }

    public void setAgiMultiplier(double agiMultiplier) {
        this.agiMultiplier = agiMultiplier;
    }

    public double getIntMultiplier() {
        return intMultiplier;
    }

    public void setIntMultiplier(double intMultiplier) {
        this.intMultiplier = intMultiplier;
    }

    public double getStaMultiplier() {
        return staMultiplier;
    }

    public void setStaMultiplier(double staMultiplier) {
        this.staMultiplier = staMultiplier;
    }


    public Set<Skill> getRaceSkills() {
        return raceSkills;
    }

    public void setRaceSkills(Set<Skill> raceSkills) {
        this.raceSkills = raceSkills;
    }
}
