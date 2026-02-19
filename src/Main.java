/**
 * Creates a zombie war simulation, runs the battle, and prints a summary report.
 */
public class Main {

    public static void main(String[] args) {

        /**
         * Creates a simulation that randomly generates survivors and zombies.
         */
        ZombieWarSimulation simulation = new ZombieWarSimulation();

        // Run the battle until one side is eliminated
        simulation.run();

        // Print the summary report
        simulation.printReport();
    }
}
