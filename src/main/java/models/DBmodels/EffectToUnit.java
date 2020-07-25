package models.DBmodels;



import javax.persistence.*;
import java.io.Serializable;

@Entity//(name = "EffectToUnit")
@Table(name = "effect_to_unit")
public class EffectToUnit implements Serializable {

        @EmbeddedId
        EffectToUnitId effectToUnitId;

        @ManyToOne
        @JoinColumn(name = "unitId", referencedColumnName = "id")
        Unit unit;

        @ManyToOne
        @JoinColumn(name = "effectId", referencedColumnName = "id")
        Effect effect;
}
