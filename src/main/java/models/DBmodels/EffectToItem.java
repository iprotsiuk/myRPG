package models.DBmodels;

import models.GAMEmodels.effects.Effect;

import javax.persistence.*;


@Entity(name = "EffectToItem")
@Table(name = "effect_to_item")
public class EffectToItem {

        @ManyToOne
        @MapsId("itemId")
        @JoinColumn(name = "itemId")
        Item item;

        @ManyToOne
        @MapsId("effectId")
        @JoinColumn(name = "effectId")
        Effect effect;
}
