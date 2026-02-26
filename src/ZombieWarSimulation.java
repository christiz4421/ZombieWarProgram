import java.util.Random;

/**
 * Manages the setup and execution of the zombie war scenario. It generates survivors
 * and zombies, runs the battle, and reports the outcome once the fighting has ended.
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

    private int numSurvivors;
    private int numZombies;

    /**
     * Random number generator used to assign random survivor
     * and zombie types.
     */
    private Random random = new Random();

    /**
     * Creates a new simulation that randomly generates the number of survivors
     * and zombies. The specific counts and types are determined using a random
     * number generator. Each character is assigned a type
     * and a unique ID.
     */
    public ZombieWarSimulation() {
        int numSurvivors = random.nextInt(20) + 1;
        int numZombies = random.nextInt(20) + 1;
        this.numSurvivors = numSurvivors;
        this.numZombies = numZombies;

        survivors = new Survivor[numSurvivors];
        zombies = new Zombie[numZombies];

        generateSurvivors();
        generateZombies();
    }

    /**
     * Randomly generates each survivor as a Child, Teacher,
     * or Soldier. Each survivor is assigned a unique ID based
     * on its position in the array.
     */
    private void generateSurvivors() {
        for (int i = 0; i < survivors.length; i++) {

            // 0 = Child, 1 = Teacher, 2 = Soldier
            int type = random.nextInt(3);

            switch (type) {
                case 0:
                    survivors[i] = new Child(i);
                    break;
                case 1:
                    survivors[i] = new Teacher(i);
                    break;
                case 2:
                    survivors[i] = new Soldier(i);
                    break;
            }
        }
    }

    /**
     * Randomly generates each zombie as either a CommonInfected
     * or a Tank. Each zombie is assigned a unique ID based on
     * its position in the array.
     */
    private void generateZombies() {
        for (int i = 0; i < zombies.length; i++) {

            // 0 = Common Infected, 1 = Tank
            int type = random.nextInt(2);

            switch (type) {
                case 0:
                    zombies[i] = new CommonInfected(i);
                    break;
                case 1:
                    zombies[i] = new Tank(i);
                    break;
            }
        }
    }

    /**
     * Runs the battle simulation. Survivors attack all zombies,
     * then zombies attack all survivors. This repeats until either all
     * of the survivors or all of the zombies are dead.
     */
    public void run() {
        while (!battleOver()) {
            survivorsAttackAllZombies();
            zombiesAttackAllSurvivors();
        }
    }

    /**
     * Makes each living survivor attack every living zombie.
     * Prints a kill message when a zombie dies.
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

                    if (!zombie.isAlive()) {
                        System.out.println(" " + survivor + " killed " + zombie);
                    }
                }
            }
        }
    }

    /**
     * Makes every living zombie attack every living survivor.
     * Prints a kill message when a survivor dies.
     */
    private void zombiesAttackAllSurvivors() {
        for (Zombie zombie : zombies) {
            if (!zombie.isAlive()) {
                continue; // Dead zombies cannot attack
            }

            for (Survivor survivor : survivors) {
                if (survivor.isAlive()) {
                    zombie.attack(survivor);
                    if (!survivor.isAlive()) {
                        System.out.println(" " + zombie + " killed " + survivor);
                    }
                }
            }
        }
    }

    /**
     * Determines if the battle is over. The battle ends when either all of the
     * survivors or all of the zombies are dead.
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
     * Prints an introduction summarizing the number and types of survivors and
     * zombies participating in the simulation.
     */
    public void printIntro() {
        int children = 0, teachers = 0, soldiers = 0;
        int infected = 0, tanks = 0;

        for (Survivor survivor : survivors) {
            if (survivor instanceof Child) children++;
            else if (survivor instanceof Teacher) teachers++;
            else if (survivor instanceof Soldier) soldiers++;
        }

        for (Zombie zombie : zombies) {
            if (zombie instanceof CommonInfected) infected++;
            else if (zombie instanceof Tank) tanks++;
        }

        System.out.println("We have " + survivors.length +
                " survivors trying to make it to safety (" +
                children + " children, " +
                teachers + " teachers, " +
                soldiers + " soldiers)");

        System.out.println("But there are " + zombies.length +
                " zombies waiting for them (" +
                infected + " common infected, " +
                tanks + " tanks)");
    }

    /**
     * Prints a message indicating whether any survivors successfully made it
     * through the battle.
     */
    public void printEnding() {
        boolean anyAlive = false;

        for (Survivor survivor : survivors) {
            if (survivor.isAlive()) {
                anyAlive = true;
                break;
            }
        }

        if (!anyAlive) {
            System.out.println("None of the survivors made it.");
        } else {
            System.out.println("Some survivors made it to safety.");
        }
    }
}