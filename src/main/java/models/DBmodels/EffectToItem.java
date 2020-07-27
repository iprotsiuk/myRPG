package models.DBmodels;


import javax.persistence.*;


@Entity//(name = "EffectToItem")
@Table(name = "effect_to_item")
public class EffectToItem {
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
