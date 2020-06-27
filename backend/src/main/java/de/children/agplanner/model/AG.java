package de.children.agplanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "ags")
public class AG {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    private String name;
    private Timestamp zeitraumStart;
    private Timestamp zeitraumEnde;
    @ManyToMany
    private List<Zeitraum> zeitraeume;
    private int groesse;
}
