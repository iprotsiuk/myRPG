package models.DBmodels;

import javax.persistence.*;


@Entity(name = "ItemToSlot")
@Table(name = "item_to_slot")
public class ItemToSlot {

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "itemId")
    Item item;

    @ManyToOne
    @MapsId("slotId")
    @JoinColumn(name = "slotId")
    Slot slot;
}
