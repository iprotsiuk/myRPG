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





    long exp;
    int currentMana;
    int currentHp;

    public Unit() {
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

    public void setRaceId(Race raceId) {
        this.race = raceId;
    }

    public Class getClassObj() {
        return _class;
    }

    public void setClassId(Class classId) {
        this._class = classId;
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

    public void setRace(Race race) {
        this.race = race;
    }

    public Class get_class() {
        return _class;
    }

    public void set_class(Class _class) {
        this._class = _class;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }
}
