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
@Table(name = "wuensche")
public class Wunsch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    @OneToOne
    private Kind kind;
    @OneToOne
    private AG wunschAG1;
    @OneToOne
    private AG wunschAG2;
    @OneToOne
    private AG wunschAG3;
    @OneToOne
    private AG wunschAG4;
}
