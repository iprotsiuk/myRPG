package models.DBmodels;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    @OneToMany(mappedBy = "item")
    Set<Slot> possibleSlots;

    int parentId;

}
