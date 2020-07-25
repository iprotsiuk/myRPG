package models.DBmodels;

import javax.persistence.*;


@Entity//(name = "ItemToLocation")
@Table(name = "item_to_location")
public class ItemToLocation {

    @EmbeddedId
    ItemToLocationId itemToLocationId;

    @ManyToOne
    @JoinColumn(name = "itemId", referencedColumnName = "id")
    Item item;

    @ManyToOne
    @JoinColumn(name = "locationId", referencedColumnName = "id")
    Location location;
}
