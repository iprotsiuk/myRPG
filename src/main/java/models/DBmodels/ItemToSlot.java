package models.DBmodels;

import javax.persistence.*;
import java.io.Serializable;


@Entity//(name = "ItemToSlot")
@Table(name = "item_to_slot")
public class ItemToSlot implements Serializable {

//    @EmbeddedId
//    ItemToSlotId itemToSlotId;

    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    Item item;

    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    Slot slot;
}
