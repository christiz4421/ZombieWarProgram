/**
 * The Main class is the entry point for the zombie war simulation.
 * It creates a simulation, prints an introduction describing the
 * characters involved, runs the battle, and prints the final outcome.
 */
public class Main {

    public static void main(String[] args) {

        /**
         * Creates a simulation that randomly generates survivors and zombies.
         *
         */
        ZombieWarSimulation simulation = new ZombieWarSimulation();

        // Prints a summary of the survivors and zombies participating.
        simulation.printIntro();

        // Runs the battle until one side is eliminated.
        simulation.run();

        // Prints the final outcome of the simulation.
        simulation.printEnding();
    }
}

