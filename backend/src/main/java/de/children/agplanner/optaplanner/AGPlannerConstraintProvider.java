package de.children.agplanner.optaplanner;

import de.children.agplanner.components.CommandLineAppStartupRunner;
import de.children.agplanner.model.AG;
import de.children.agplanner.model.Kind;
import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;


public class AGPlannerConstraintProvider implements EasyScoreCalculator<AGVerteilung> {

    private static final Logger LOG = LoggerFactory.getLogger(AGPlannerConstraintProvider.class);


    @Override
    public Score calculateScore(AGVerteilung agVerteilung) {
        int hardScore = 0;
        int softScore = 0;
        Iterator<Kind> i = agVerteilung.getKindListe().iterator();
        while (i.hasNext()) {
            Kind kind = i.next(); // must be called before you can call i.remove()
            for (AG ag : agVerteilung.getAgListe()){
                if(ag.getGroesse() > ag.getKinder().size()){
                    /*if(ag.getID() == kind.getWunsch().getWunschAG1().getID()) {
                        softScore += 0;
                    } else if (ag.getID() == kind.getWunsch().getWunschAG2().getID()) {
                        // Penalize second wish
                        softScore -= 1;
                    }*/
                    ag.getKinder().add(kind);
                    i.remove();
                    break;
                }
            }
        }
        hardScore -= agVerteilung.getKindListe().size();

        return HardSoftScore.valueOf(hardScore, softScore);
    }
}
