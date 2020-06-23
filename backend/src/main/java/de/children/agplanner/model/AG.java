package de.children.agplanner.model;

import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
public class AG {

    @Id
    private int id;
    private String name;
    private Timestamp zeitraumStart;
    private Timestamp zeitraumEnde;
    @ManyToMany
    private List<Zeitraum> zeitraeume;
    private int groesse;
}
