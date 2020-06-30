package de.children.agplanner.optaplanner;

import de.children.agplanner.model.AG;
import de.children.agplanner.model.Kind;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.ArrayList;
import java.util.List;

@PlanningSolution
public class AGVerteilung {
    private List<AG> agListe;
    private HardSoftScore score;
    private List<Integer> groesseListe = new ArrayList<>();

    @ValueRangeProvider(id = "verfuegbareGroesse")
    @ProblemFactCollectionProperty
    public List<Integer> getGroesse() {
        return groesseListe;
    }

    public void setGroesse(List<Integer> groesseListe) {
        this.groesseListe = groesseListe;
    }


    @PlanningEntityCollectionProperty
    public List<AG> getAgListe() {
        if(agListe == null){
            return new ArrayList<>();
        }
        return agListe;
    }

    public  void setAgListe(List<AG> agListe) {
        this.agListe = agListe;
    }

    @PlanningScore
    public HardSoftScore getScore() {
        return score;
    }
    public void setScore(HardSoftScore score) {
        this.score = score;
    }

}
