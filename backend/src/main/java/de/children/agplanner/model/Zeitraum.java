package de.children.agplanner.model;

import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@Entity
public class Zeitraum {
    @Id
    private Integer id;
    private String wochentag;
    private Timestamp startZeit;
    private Timestamp endZeit;
    @ManyToMany
    private List<AG> ags;
}
