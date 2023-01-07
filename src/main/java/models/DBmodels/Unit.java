package models.DBmodels;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "unit")
public class Unit  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    Race race;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    Class _class;


    int FOW;


    long exp;
    int currentMana;
    int currentHp;

    public Unit() {
    }

    public Unit(Race race, Class _class, int currentMana, int currentHp) {
        this.race = race;
        this._class = _class;
        this.currentMana = currentMana;
        this.currentHp = currentHp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Class get_class() {
        return _class;
    }

    public void set_class(Class _class) {
        this._class = _class;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }
}
