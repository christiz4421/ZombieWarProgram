import java.util.Random;

public class ZombieWar {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Survivor[] survivors = generateSurvivors();
        Zombie[] zombies = generateZombies();

        System.out.println("We have " + survivors.length + " survivors trying to make it to safety.");
        System.out.println();
        System.out.println("But there are " + zombies.length + " zombies waiting for them.");
        System.out.println();

        int survivorCount = countLivingSurvivors(survivors);
        int zombieCount = countLivingZombies(zombies);
        while (survivorCount > 0 && zombieCount > 0) {
            survivorsAttack(survivors, zombies);
            zombiesAttack(zombies, survivors);
            survivorCount = countLivingSurvivors(survivors);
            zombieCount = countLivingZombies(zombies);
        }

        System.out.println("It seems " + survivorCount + " have made it to safety.");
    }

    private static int countLivingSurvivors(Survivor[] survivors) {
        int count = 0;
        for (Survivor survivor : survivors) {
            if (survivor.isAlive()) {
                count++;
            }
        }
        return count;
    }

    private static int countLivingZombies(Zombie[] zombies) {
        int count = 0;
        for (Zombie zombie : zombies) {
            if (zombie.isAlive()) {
                count++;
            }
        }
        return count;
    }

    private static Survivor[] generateSurvivors() {
        int count = 5 + RANDOM.nextInt(11);
        Survivor[] survivors = new Survivor[count];
        for (int i = 0; i < count; i++) {
            int roll = RANDOM.nextInt(3);
            if (roll == 0) {
                survivors[i] = new Soldier();
            } else if (roll == 1) {
                survivors[i] = new Teacher();
            } else {
                survivors[i] = new Child();
            }
        }
        return survivors;
    }

    private static Zombie[] generateZombies() {
        int count = 5 + RANDOM.nextInt(11);
        Zombie[] zombies = new Zombie[count];
        for (int i = 0; i < count; i++) {
            if (RANDOM.nextInt(2) == 0) {
                zombies[i] = new CommonInfected();
            } else {
                zombies[i] = new Tank();
            }
        }
        return zombies;
    }

    private static void survivorsAttack(Survivor[] survivors, Zombie[] zombies) {
        for (Survivor survivor : survivors) {
            if (!survivor.isAlive()) {
                continue;
            }
            for (Zombie zombie : zombies) {
                if (!zombie.isAlive()) {
                    continue;
                }
                survivor.attack(zombie);
            }
        }
    }

    private static void zombiesAttack(Zombie[] zombies, Survivor[] survivors) {
        for (Zombie zombie : zombies) {
            if (!zombie.isAlive()) {
                continue;
            }
            for (Survivor survivor : survivors) {
                if (!survivor.isAlive()) {
                    continue;
                }
                zombie.attack(survivor);
            }
        }
    }


}
