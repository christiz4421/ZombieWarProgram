import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZombieWar {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Survivor[] survivors = generateSurvivors();
        Zombie[] zombies = generateZombies();

        int childCount = countType(survivors, Child.class);
        int teacherCount = countType(survivors, Teacher.class);
        int soldierCount = countType(survivors, Soldier.class);

        int commonCount = countType(zombies, CommonInfected.class);
        int tankCount = countType(zombies, Tank.class);

        System.out.println("We have " + survivors.length + " survivors trying to make it to safety (" +
                childCount + " children, " + teacherCount + " teachers, " + soldierCount + " soldiers)");
        System.out.println();
        System.out.println("But there are " + zombies.length + " zombies waiting for them (" +
                commonCount + " common infected, " + tankCount + " tanks)");
        System.out.println();

        List<String> battleLog = new ArrayList<>();
        int survivorCount = countSurvivors(survivors);
        int zombieCount = countZombies(zombies);
        while (survivorCount > 0 && zombieCount > 0) {
            survivorsAttack(survivors, zombies, battleLog);
            zombiesAttack(zombies, survivors, battleLog);
            survivorCount = countSurvivors(survivors);
            zombieCount = countZombies(zombies);
        }

        for (String entry : battleLog) {
            System.out.println("   " + entry);
            System.out.println();
        }

        if (survivorCount == 0) {
            System.out.println("None of the survivors made it.");
        } else {
            System.out.println("It seems " + survivorCount + " have made it to safety.");
        }
    }

    private static int countSurvivors(Survivor[] survivors) {
        int count = 0;
        for (Survivor survivor : survivors) {
            if (survivor.isAlive()) {
                count++;
            }
        }
        return count;
    }

    private static int countZombies(Zombie[] zombies) {
        int count = 0;
        for (Zombie zombie : zombies) {
            if (zombie.isAlive()) {
                count++;
            }
        }
        return count;
    }

    private static int countType(Survivor[] survivors, Class<? extends Survivor> type) {
        int count = 0;
        for (Survivor survivor : survivors) {
            if (type.isInstance(survivor)) {
                count++;
            }
        }
        return count;
    }

    private static int countType(Zombie[] zombies, Class<? extends Zombie> type) {
        int count = 0;
        for (Zombie zombie : zombies) {
            if (type.isInstance(zombie)) {
                count++;
            }
        }
        return count;
    }

    private static Survivor[] generateSurvivors() {
        int count = 5 + RANDOM.nextInt(5);
        Survivor[] survivors = new Survivor[count];
        int soldierId = 0;
        int teacherId = 0;
        int childId = 0;
        for (int i = 0; i < count; i++) {
            int roll = RANDOM.nextInt(100);
            if (roll < 20) {
                survivors[i] = new Child(childId);
                childId++;
            } else if (roll < 60) {
                survivors[i] = new Teacher(teacherId);
                teacherId++;
            } else {
                survivors[i] = new Soldier(soldierId);
                soldierId++;
            }
        }
        return survivors;
    }

    private static Zombie[] generateZombies() {
        int count = 3 + RANDOM.nextInt(5);
        Zombie[] zombies = new Zombie[count];
        int commonId = 0;
        int tankId = 0;
        for (int i = 0; i < count; i++) {
            if (RANDOM.nextInt(100) < 66) {
                zombies[i] = new CommonInfected(commonId);
                commonId++;
            } else {
                zombies[i] = new Tank(tankId);
                tankId++;
            }
        }
        return zombies;
    }

    private static void survivorsAttack(Survivor[] survivors, Zombie[] zombies, List<String> battleLog) {
        for (Survivor survivor : survivors) {
            if (!survivor.isAlive()) {
                continue;
            }
            for (Zombie zombie : zombies) {
                if (!zombie.isAlive()) {
                    continue;
                }
                survivor.attack(zombie);
                if (!zombie.isAlive()) {
                    battleLog.add(survivor.getLabel() + " killed " + zombie.getLabel());
                }
            }
        }
    }

    private static void zombiesAttack(Zombie[] zombies, Survivor[] survivors, List<String> battleLog) {
        for (Zombie zombie : zombies) {
            if (!zombie.isAlive()) {
                continue;
            }
            for (Survivor survivor : survivors) {
                if (!survivor.isAlive()) {
                    continue;
                }
                zombie.attack(survivor);
                if (!survivor.isAlive()) {
                    battleLog.add(zombie.getLabel() + " killed " + survivor.getLabel());
                }
            }
        }
    }


}
