package models.DBmodels;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    @OneToMany(targetEntity = Slot.class)
    Set<Slot> possibleSlots;

    int parentId;

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Slot> getPossibleSlots() {
        return possibleSlots;
    }

    public void setPossibleSlots(Set<Slot> possibleSlots) {
        this.possibleSlots = possibleSlots;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
