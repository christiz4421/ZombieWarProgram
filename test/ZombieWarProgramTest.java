import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ZombieWarProgramTest
 *
 * Description:
 * This class contains basic tests for the Zombie War simulation. The tests verify that the program
 * can be created, executed, and completed without errors.
 *
 * Source: https://www.vogella.com/tutorials/JUnit/article.html
 */
public class ZombieWarProgramTest {

    // Test to see that the simulation can be created
    @Test
    public void testCreateSimulation() {
        ZombieWarSimulation simulation = new ZombieWarSimulation();
        assertNotNull(simulation);
    }

    // Test to see that the scenario can be printed without errors
    @Test
    public void testPrintScenario() {
        ZombieWarSimulation simulation = new ZombieWarSimulation();
        simulation.printScenario();
    }

    // Test to see that the simulation runs without crashing
    @Test
    public void testRunSimulation() {
        ZombieWarSimulation simulation = new ZombieWarSimulation();
        simulation.run();
    }

    // Test to see that the report can be printed after the simulation runs
    @Test
    public void testPrintReportAfterRun() {
        ZombieWarSimulation simulation = new ZombieWarSimulation();
        simulation.run();
        simulation.printReport();
    }

    // Test to see that the main method runs without errors
    @Test
    public void testMainRuns() {
        Main.main(new String[0]);
    }
}