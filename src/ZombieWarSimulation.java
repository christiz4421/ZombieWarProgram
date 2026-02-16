import java.util.Random;

/**
 * Manages the setup and execution of the zombie war scenario.
 *
 * Randomly generates survivors and zombies, runs the battle
 * until one side is eliminated, and prints a summary report
 * showing how many survivors made it to safety.
 */
public class ZombieWarSimulation {

    /**
     * The array of survivors participating in the simulation.
     */
    private Survivor[] survivors;

    /**
     * The array of zombies the survivors have to fight.
     */
    private Zombie[] zombies;

    /**
     * Random number generator that is used to assign random types
     * of survivors and zombies.
     */
    private Random random = new Random();

    /**
     * Creates a new simulation with the specified number of
     * survivors and zombies.
     *
     * @param numSurvivors the number of survivors to generate
     * @param numZombies   the number of zombies to generate
     */
    public ZombieWarSimulation(int numSurvivors, int numZombies) {
        survivors = new Survivor[numSurvivors];
        zombies = new Zombie[numZombies];

        generateSurvivors();
        generateZombies();
    }

    /**
     * Randomly generates each survivor as a Child, Teacher, or Soldier.
     */
    private void generateSurvivors() {
        for (int i = 0; i < survivors.length; i++) {
            // 0 = Child, 1 = Teacher, 2 = Soldier
            int type = random.nextInt(3);

            switch (type) {
                case 0:
                    survivors[i] = new Child();
                    break;
                case 1:
                    survivors[i] = new Teacher();
                    break;
                case 2:
                    survivors[i] = new Soldier();
                    break;
            }
        }
    }

    /**
     * Randomly generates each zombie as a Common Infected or Tank.
     */
    private void generateZombies() {
        for (int i = 0; i < zombies.length; i++) {
            // 0 = Common Infected, 1 = Tank
            int type = random.nextInt(2);

            switch (type) {
                case 0:
                    zombies[i] = new CommonInfected();
                    break;
                case 1:
                    zombies[i] = new Tank();
                    break;
            }
        }
    }

    /**
     * Runs the battle simulation. Survivors attack all zombies, then zombies
     * attack all survivors. This repeats until either all survivors or all
     * zombies are dead.
     */
    public void run() {
        while (!battleOver()) {
            survivorsAttackAllZombies();
            zombiesAttackAllSurvivors();
        }
    }

    /**
     * Makes every living survivor attack every living zombie.
     */
    private void survivorsAttackAllZombies() {
        for (Survivor survivor : survivors) {
            // Dead survivors are unable to attack
            if (!survivor.isAlive()) {
                continue;
            }

            for (Zombie zombie : zombies) {
                if (zombie.isAlive()) {
                    survivor.attack(zombie);
                }
            }
        }
    }

    /**
     * Makes every living zombie attack every living survivor.
     */
    private void zombiesAttackAllSurvivors() {
        for (Zombie zombie : zombies) {
            if (!zombie.isAlive()) {
                continue; // Dead zombies cannot attack
            }

            for (Survivor survivor : survivors) {
                if (survivor.isAlive()) {
                    zombie.attack(survivor);
                }
            }
        }
    }

    /**
     * Determines if the battle is over. The battle ends when
     * either all survivors or all zombies are dead.
     *
     * @return true if the battle is over, false otherwise
     */
    private boolean battleOver() {
        boolean survivorsAlive = false;
        boolean zombiesAlive = false;

        for (Survivor survivor : survivors) {
            if (survivor.isAlive()) {
                survivorsAlive = true;
            }
        }

        for (Zombie zombie : zombies) {
            if (zombie.isAlive()) {
                zombiesAlive = true;
            }
        }

        return !survivorsAlive || !zombiesAlive;
    }

    /**
     * Prints a summary report that includes the number of survivors generated,
     * the number of zombies generated, and how many survivors made it to safety.
     */
    public void printReport() {
        int alive = 0;

        for (Survivor survivor : survivors) {
            if (survivor.isAlive()) {
                alive++;
            }
        }

        System.out.println("We have " + survivors.length + " survivors trying to make it to safety.");
        System.out.println("But there are " + zombies.length + " zombies waiting for them.");
        System.out.println("It seems " + alive + " have made it to safety.");
    }
}
