package de.children.agplanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.ProblemFactProperty;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@PlanningEntity
@Entity
@Table(name = "kinder")
public class Kind {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String name;
    private int schuljahr;

    @ManyToOne
    private AG ag;

    @PlanningVariable(valueRangeProviderRefs = {"agsOpta"})
    public AG getAg() {
        return this.ag;
    }

    public void setAg(AG ag) {
        this.ag = ag;
    }

    public List<Wunsch> getWunsch() {
        return this.wunsch;
    }

    public void setWunsch(List<Wunsch> wunsch) {
        this.wunsch = wunsch;
    }

    @ManyToMany(fetch=FetchType.EAGER)
    private List<Wunsch> wunsch = new ArrayList<>();

}
