package de.children.agplanner.optaplanner;

import de.children.agplanner.model.AG;
import de.children.agplanner.model.Kind;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

@PlanningSolution
public class AGVerteilung {
    private List<AG> agListe;
    private List<Kind> kindListe;
    private HardSoftScore score;
    private List<Integer> groeßeListe;

    @ValueRangeProvider(id = "verfuegbareGroesse")
    @ProblemFactCollectionProperty
    public List<Integer> getGroeße() {
        return groeßeListe;
    }


    @PlanningEntityCollectionProperty
    public List<AG> getAgListe() {
        return agListe;
    }

    @PlanningScore
    public HardSoftScore getScore() {
        return score;
    }
    public void setScore(HardSoftScore score) {
        this.score = score;
    }

}
