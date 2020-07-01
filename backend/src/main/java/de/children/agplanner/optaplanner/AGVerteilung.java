package de.children.agplanner.optaplanner;

import de.children.agplanner.model.AG;
import de.children.agplanner.model.Kind;
import de.children.agplanner.model.Wunsch;
import org.optaplanner.core.api.domain.solution.*;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.ArrayList;
import java.util.List;

@PlanningSolution
public class AGVerteilung {
    private HardSoftScore score;
    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "agOpta")
    private List<AG> agListe;

    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "wunschOpta")
    private List<Wunsch> wunschListe = new ArrayList<Wunsch>();

    @PlanningEntityCollectionProperty
    private List<Kind> kindListe = new ArrayList<>();


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

    public List<Kind> getKindListe() {
        return kindListe;
    }

    public void setKindListe(List<Kind> kindListe) {
        this.kindListe = kindListe;
    }


    public List<Wunsch> getWunschListe() {

        return wunschListe;
    }

    public void setWunschListe(List<Wunsch> wunschListe) {
        this.wunschListe = wunschListe;
    }
}
