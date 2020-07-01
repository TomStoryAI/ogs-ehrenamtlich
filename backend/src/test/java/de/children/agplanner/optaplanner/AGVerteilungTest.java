package de.children.agplanner.optaplanner;

import de.children.agplanner.service.AGService;
import de.children.agplanner.service.KindService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ImportResource(value="classpath:hsqldb_properties.xml") // Start hsql server to access from application
@SpringBootTest
class AGVerteilungTest {

    @Autowired
    AGService agService;

    @Autowired
    KindService kindService;

    AGVerteilung unsolvedAGVerteilung;

    @Before
    public void setUp() {

        unsolvedAGVerteilung = new AGVerteilung();
        List kinder = kindService.getAllChildren();
        unsolvedAGVerteilung.setAgListe(agService.getAllChildren());
        unsolvedAGVerteilung.setKindListe(kindService.getAllChildren());
    }

    @Test
    public void testStuff() {
    setUp();
        SolverFactory<AGVerteilung> solverFactory = SolverFactory
                .createFromXmlResource("agVerteilung.xml");
        Solver<AGVerteilung> solver = solverFactory.buildSolver();

        AGVerteilung solvedCourseSchedule = solver.solve(unsolvedAGVerteilung);

        assertNotNull(solvedCourseSchedule.getScore());
        assertEquals(-4, solvedCourseSchedule.getScore().getHardScore());
    }

}