package de.children.agplanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "zeitraeume")
public class Zeitraum {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    private String wochentag;
    private Timestamp startZeit;
    private Timestamp endZeit;
    @ManyToMany
    private List<AG> ags;
}
