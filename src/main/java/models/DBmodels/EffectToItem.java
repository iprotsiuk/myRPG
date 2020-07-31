package models.DBmodels;


import javax.persistence.*;
import java.io.Serializable;


@Entity//(name = "EffectToItem")
@Table(name = "effect_to_item")
public class EffectToItem implements Serializable {
//        @EmbeddedId
//        EffectToItemId effectToItemId;

        @Id
        @ManyToOne
        @JoinColumn(referencedColumnName = "id")
        Item item;

        @Id
        @ManyToOne
        @JoinColumn(referencedColumnName = "id")
        Effect effect;
}
