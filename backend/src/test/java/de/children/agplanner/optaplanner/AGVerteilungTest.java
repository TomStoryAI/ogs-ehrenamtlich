package de.children.agplanner.optaplanner;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AGVerteilungTest {

    @Test
    public void testStuff() {

        SolverFactory<AGVerteilung> solverFactory = SolverFactory
                .createFromXmlResource("agVerteilung.xml");
        Solver<AGVerteilung> solver = solverFactory.buildSolver();

       /* AGVerteilung unsolvedAGVerteilung = new AGVerteilung();
        AGVerteilung solvedCourseSchedule = solver.solve(unsolvedAGVerteilung);

        assertNotNull(solvedCourseSchedule.getScore());
        assertEquals(-4, solvedCourseSchedule.getScore().getHardScore());*/
    }

}