package models.DBmodels;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Inventory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    Unit unit;

    @OneToOne
    Item item;

    public Inventory() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
