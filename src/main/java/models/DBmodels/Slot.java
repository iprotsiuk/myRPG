package models.DBmodels;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Slot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true)
    String name;

    public Slot() {
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

    //    @ManyToOne
//    Set<Item> possibleSlots;



}
