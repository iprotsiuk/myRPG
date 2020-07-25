package models.DBmodels;

import javax.persistence.*;
import java.io.Serializable;


@Entity//(name = "ItemToSlot")
@Table(name = "item_to_slot")
public class ItemToSlot implements Serializable {

    @EmbeddedId
    ItemToSlotId itemToSlotId;

    @ManyToOne
    @JoinColumn(name = "itemId", referencedColumnName = "id")
    Item item;

    @ManyToOne
    @JoinColumn(name = "slotId", referencedColumnName = "id")
    Slot slot;
}
