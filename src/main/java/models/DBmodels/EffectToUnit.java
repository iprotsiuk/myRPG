package models.DBmodels;



import javax.persistence.*;
import java.io.Serializable;

@Entity//(name = "EffectToUnit")
@Table(name = "effect_to_unit")
public class EffectToUnit implements Serializable {

//        @EmbeddedId
//        EffectToUnitId effectToUnitId;

        @Id
        @ManyToOne
        @JoinColumn(referencedColumnName = "id")
        Unit unit;

        @Id
        @ManyToOne
        @JoinColumn(referencedColumnName = "id")
        Effect effect;
}
