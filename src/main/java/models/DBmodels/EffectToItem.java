package models.DBmodels;


import javax.persistence.*;


@Entity//(name = "EffectToItem")
@Table(name = "effect_to_item")
public class EffectToItem {
        @EmbeddedId
        EffectToItemId effectToItemId;

        @ManyToOne
        @JoinColumn(name = "itemId", referencedColumnName = "id")
        Item item;

        @ManyToOne
        @JoinColumn(name = "effectId", referencedColumnName = "id")
        Effect effect;
}
