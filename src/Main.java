/**
 * Creates a zombie was simulation, runs the battle, and prints a summary report.
 */
public class Main {

    public static void main(String[] args) {

        /**
         * Creates a simulation with a specified number of survivors and zombies.
         */
        ZombieWarSimulation simulation = new ZombieWarSimulation(17, 8);

        // Run the battle until one side is eliminated
        simulation.run();

        // Print the summary report
        simulation.printReport();
    }
}