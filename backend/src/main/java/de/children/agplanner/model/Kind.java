package de.children.agplanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "kinder")
@PlanningEntity
public class Kind {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String name;
    private int schuljahr;
    @PlanningVariable(valueRangeProviderRefs = {"agOpta"})
    @ManyToOne
    private AG ags;
    @OneToOne
    private Wunsch wunsch;
}
