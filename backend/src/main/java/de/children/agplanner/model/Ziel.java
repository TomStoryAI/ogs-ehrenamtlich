package de.children.agplanner.model;

import org.springframework.data.annotation.Id;

import javax.persistence.OneToMany;
import java.util.List;

public class Ziel {

    @Id
    private int id;
    private AG ag;
    @OneToMany
    private List<Kind> kinder;
    private int halbjahr;


}
