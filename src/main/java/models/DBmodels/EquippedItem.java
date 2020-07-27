package models.DBmodels;

import org.apache.catalina.User;

import javax.persistence.*;


@Entity
public class EquippedItem {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    Unit unit;

    @OneToOne
    Item item;

    @OneToOne
    Slot gearSlot;


    public EquippedItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Unit getUnitId() {
        return unit;
    }

    public void setUnitId(Unit unitId) {
        this.unit = unit;
    }

    public Item getItemId() {
        return item;
    }

    public void setItemId(Item item) {
        this.item = item;
    }

    public Slot getGearSlot() {
        return gearSlot;
    }

    public void setGearSlot(Slot gearSlot) {
        this.gearSlot = gearSlot;
    }
}
