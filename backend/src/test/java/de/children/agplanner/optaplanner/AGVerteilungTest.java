package de.children.agplanner.optaplanner;

import de.children.agplanner.model.AG;
import de.children.agplanner.model.Kind;
import de.children.agplanner.service.AGService;
import de.children.agplanner.service.KindService;
import de.children.agplanner.service.WunschService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ImportResource(value="classpath:hsqldb_properties.xml") // Start hsql server to access from application
@SpringBootTest
class AGVerteilungTest {

    @Autowired
    AGService agService;

    @Autowired
    KindService kindService;

    @Autowired
    WunschService wunschService;

    AGVerteilung unsolvedAGVerteilung;

    @Before
    public void setUp() {
        unsolvedAGVerteilung = new AGVerteilung();
        List<AG> allAGs = agService.getAllChildren();
        List<Kind> allKinder = kindService.getAllChildren();
        unsolvedAGVerteilung.setAgListe(allAGs);
        unsolvedAGVerteilung.setKindListe(allKinder);
    }

    @Test
    public void testStuff() {
    setUp();
        SolverFactory<AGVerteilung> solverFactory = SolverFactory
                .createFromXmlResource("agVerteilung.xml");
        Solver<AGVerteilung> solver = solverFactory.buildSolver();

        AGVerteilung solvedCourseSchedule = solver.solve(unsolvedAGVerteilung);

        assertNotNull(solvedCourseSchedule.getScore());
        assertEquals(0, solvedCourseSchedule.getScore().getHardScore());
        assertEquals(0, solvedCourseSchedule.getScore().getSoftScore());
    }

}