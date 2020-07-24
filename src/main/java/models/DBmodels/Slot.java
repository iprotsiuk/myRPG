package models.DBmodels;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    String name;



}
