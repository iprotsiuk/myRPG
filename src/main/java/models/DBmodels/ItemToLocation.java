package models.DBmodels;

import javax.persistence.*;


@Entity(name = "ItemToLocation")
@Table(name = "item_to_location")
public class ItemToLocation {


    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "itemId")
    Item item;

    @ManyToOne
    @MapsId("locationId")
    @JoinColumn(name = "locationId")
    Location location;
}
