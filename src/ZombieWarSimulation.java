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
     * Index for each survivor based on their type (e.g., Soldier 0, Soldier 1).
     */
    private int[] survivorTypeIndex;

    /**
     * Index for each zombie based on their type (e.g., Tank 0, Tank 1).
     */
    private int[] zombieTypeIndex;

    /**
     * Creates a new simulation that randomly generates the number of survivors
     * and zombies. The specific counts and types are determined using a random
     * number generator.
     */
    public ZombieWarSimulation() {

        int numSurvivors = random.nextInt(11) + 5;  // 5 to 15 survivors
        int numZombies = random.nextInt(10) + 1;    // 1 to 10 zombies

        survivors = new Survivor[numSurvivors];
        zombies = new Zombie[numZombies];
        survivorTypeIndex = new int[numSurvivors];
        zombieTypeIndex = new int[numZombies];

        generateSurvivors();
        generateZombies();
    }

    /**
     * Randomly generates each survivor as a Child, Teacher, or Soldier.
     * Odds: 20% Child, 50% Teacher, 30% Soldier
     */
    private void generateSurvivors() {
        int childCount = 0, teacherCount = 0, soldierCount = 0;

        for (int i = 0; i < survivors.length; i++) {
            int roll = random.nextInt(100);

            if (roll < 20) {
                // Child
                survivors[i] = new Child();
                survivorTypeIndex[i] = childCount++;
            } else if (roll < 70) {
                // Teacher
                survivors[i] = new Teacher();
                survivorTypeIndex[i] = teacherCount++;
            } else {
                // Soldier
                survivors[i] = new Soldier();
                survivorTypeIndex[i] = soldierCount++;
            }
        }
    }

    /**
     * Randomly generates each zombie as a CommonInfected or Tank.
     * Odds: 65% CommonInfected, 35% Tank
     */
    private void generateZombies() {
        int commonCount = 0, tankCount = 0;

        for (int i = 0; i < zombies.length; i++) {
            int roll = random.nextInt(100);

            if (roll < 65) {
                // CommonInfected
                zombies[i] = new CommonInfected();
                zombieTypeIndex[i] = commonCount++;
            } else {
                // Tank
                zombies[i] = new Tank();
                zombieTypeIndex[i] = tankCount++;
            }
        }
    }

    /**
     * Runs the battle simulation. Survivors attack all zombies, then zombies
     * attack all survivors. This repeats until either all of the survivors or
     * all of the zombies are dead.
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
        for (int i = 0; i < survivors.length; i++) {
            Survivor survivor = survivors[i];
            if (!survivor.isAlive()) {
                continue;
            }

            //Prints the survivor's attack and if they killed any zombies
             System.out.println(survivor.getClass().getSimpleName() + " " + survivorTypeIndex[i]
                    + " attacks all zombies!"); 
            for (int j = 0; j < zombies.length; j++) {
                Zombie zombie = zombies[j];
                if (zombie.isAlive()) {
                    survivor.attack(zombie);
                    if (!zombie.isAlive()) {
                        System.out.println(survivor.getClass().getSimpleName() + " " + survivorTypeIndex[i]
                                + " killed " + zombie.getClass().getSimpleName() + " " + zombieTypeIndex[j]);
                        System.out.println();
                    }
                }
            }
        }
    }

    /**
     * Makes every living zombie attack every living survivor.
     */
    private void zombiesAttackAllSurvivors() {
        for (int i = 0; i < zombies.length; i++) {
            Zombie zombie = zombies[i];
            if (!zombie.isAlive()) {
                continue;
            }

            //Prints the zombie's attack and if they killed any survivors
             System.out.println(zombie.getClass().getSimpleName() + " " + zombieTypeIndex[i]
                    + " attacks all survivors!");
            for (int j = 0; j < survivors.length; j++) {
                Survivor survivor = survivors[j];
                if (survivor.isAlive()) {
                    zombie.attack(survivor);
                    if (!survivor.isAlive()) {
                        System.out.println(zombie.getClass().getSimpleName() + " " + zombieTypeIndex[i]
                                + " killed " + survivor.getClass().getSimpleName() + " " + survivorTypeIndex[j]);
                        System.out.println();
                    }
                }
            }
        }
    }

    /**
     * Determines if the battle is over. The battle ends when
     * either all of the survivors or all of the zombies are dead.
     *
     * @return true if the battle is over, otherwise return false
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

        if (alive == 0) {
            System.out.println("None of the survivors made it.");
        } else {
            System.out.println("It seems " + alive + " have made it to safety.");
        }
    }

    /**
     * Prints the initial scenario before the battle begins.
     */
    public void printScenario() {
        int children = 0, teachers = 0, soldiers = 0;
        for (Survivor survivor : survivors) {
            if (survivor instanceof Child) children++;
            else if (survivor instanceof Teacher) teachers++;
            else if (survivor instanceof Soldier) soldiers++;
        }

        int commonInfected = 0, tanks = 0;
        for (Zombie zombie : zombies) {
            if (zombie instanceof CommonInfected) commonInfected++;
            else if (zombie instanceof Tank) tanks++;
        }

        System.out.println("We have " + survivors.length
                + " survivors trying to make it to safety ("
                + children + " children, "
                + teachers + " teachers, "
                + soldiers + " soldiers)");
        System.out.println();
        System.out.println("But there are " + zombies.length
                + " zombies waiting for them ("
                + commonInfected + " common infected, "
                + tanks + " tanks)");
        System.out.println();
    }
}
