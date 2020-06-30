package de.children.agplanner.optaplanner;

import de.children.agplanner.components.CommandLineAppStartupRunner;
import de.children.agplanner.model.AG;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AGPlannerConstraintProvider implements ConstraintProvider {

    private static final Logger LOG = LoggerFactory.getLogger(AGPlannerConstraintProvider.class);
    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{
                groessenKonflikt(constraintFactory),
        };
    }

    private Constraint groessenKonflikt(ConstraintFactory factory) {
        // Größe soll vernünftig gesetzt werden
        return factory.from(AG.class).filter(ag -> ag.getGroesse() < ag.getKinder().size()).penalize("AG-Groeße",
                HardSoftScore.ONE_HARD, (ag) -> ag.getKinder().size() - ag.getGroesse());
    }
}
