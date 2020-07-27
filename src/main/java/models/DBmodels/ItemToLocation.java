package models.DBmodels;

import javax.persistence.*;


@Entity//(name = "ItemToLocation")
@Table(name = "item_to_location")
public class ItemToLocation {

//    @EmbeddedId
//    ItemToLocationId itemToLocationId;

    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    Item item;

    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    Location location;
}
