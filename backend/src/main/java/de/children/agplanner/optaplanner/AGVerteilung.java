package de.children.agplanner.optaplanner;

import de.children.agplanner.model.AG;
import de.children.agplanner.model.Kind;
import org.optaplanner.core.api.domain.solution.*;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.ArrayList;
import java.util.List;

@PlanningSolution
public class AGVerteilung {
    private HardSoftScore score;

    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "agsOpta")
    private List<AG> agListe;

    private List<Kind> kindListe = new ArrayList<>();

    public List<AG> getAgListe() {
        return this.agListe;
    }
    public void setAgListe(List<AG> agListe) {
        this.agListe = agListe;
    }

    @PlanningScore
    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) { this.score = score; }

    @PlanningEntityCollectionProperty
    public List<Kind> getKindListe() {
        return kindListe;
    }

    public void setKindListe(List<Kind> kindListe) {
        this.kindListe = kindListe;
    }
}
