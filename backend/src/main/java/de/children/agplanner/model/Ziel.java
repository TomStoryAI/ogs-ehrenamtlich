package de.children.agplanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "ziele")
public class Ziel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    // private AG ag;
    @OneToMany
    private List<Kind> kinder;
    private int halbjahr;


}
