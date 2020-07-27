package models.DBmodels;

import javax.persistence.*;
import java.io.Serializable;

// Экран выбора перса в вове
@Entity
public class gameCharacter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    String name; // name перса

    @OneToOne // сам перс
    Unit unit;


    public gameCharacter() {
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

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

}
