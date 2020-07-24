package models.DBmodels;

import models.GAMEmodels.effects.Effect;

import javax.persistence.*;
@Entity(name = "EffectToUnit")
@Table(name = "effect_to_unit")
public class EffectToUnit {

        @ManyToOne
        @MapsId("unitId")
        @JoinColumn(name = "unitId")
        Unit unit;

        @ManyToOne
        @MapsId("effectId")
        @JoinColumn(name = "effectId")
        Effect effect;
}
