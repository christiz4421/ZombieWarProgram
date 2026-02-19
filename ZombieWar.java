// Tommy, Zach, Dennis.
// Wk 5 ZombieWar engine.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZombieWar {

    public static void main(String[] args) {
        System.out.println("=== Zombie War Simulation ===");

        // -----------------------------
        // Release 1.0 Output
        // -----------------------------
        System.out.println("\n--- Release 1.0: Randomized Groups ---");
        List<Survivor> r1Survivors = generateRandomSurvivors();
        List<Zombie> r1Zombies = generateRandomZombies();
        runSimulation(r1Survivors, r1Zombies, false);

        // -----------------------------
        // Release 2.0 Output
        // -----------------------------
        System.out.println("\n--- Release 2.0: Fixed Groups with Kill Log ---");
        List<Survivor> r2Survivors = generateFixedSurvivors();
        List<Zombie> r2Zombies = generateFixedZombies();
        runSimulation(r2Survivors, r2Zombies, true);
    }

    // ============================================================
    // SIMULATION ENGINE
    // ============================================================
    public static void runSimulation(List<Survivor> survivors, List<Zombie> zombies, boolean logKills) {
        List<String> killLog = new ArrayList<>();

        while (!survivors.isEmpty() && !zombies.isEmpty()) {
            Survivor s = survivors.get(0);
            Zombie z = zombies.get(0);

            // Survivor attacks zombie
            z.takeDamage(s.getAttack());
            if (!z.isAlive()) {
                if (logKills) killLog.add(s + " killed " + z);
                zombies.remove(0);
                continue;
            }

            // Zombie attacks survivor
            s.takeDamage(z.getAttack());
            if (!s.isAlive()) {
                if (logKills) killLog.add(z + " killed " + s);
                survivors.remove(0);
            }
        }

        // Final outcome
        if (survivors.isEmpty()) {
            System.out.println("None of the survivors made it.");
        } else {
            System.out.println(survivors.size() + " have made it to safety.");
        }

        // Kill log for Release 2.0
        if (logKills) {
            System.out.println("\nKill Log:");
            for (String entry : killLog) {
                System.out.println("   " + entry);
            }
        }
    }

    // ============================================================
    // RANDOM GROUPS (Release 1.0)
    // ============================================================
    public static List<Survivor> generateRandomSurvivors() {
        Random r = new Random();
        List<Survivor> list = new ArrayList<>();

        int numChildren = r.nextInt(5) + 1;
        int numTeachers = r.nextInt(5) + 1;
        int numSoldiers = r.nextInt(5) + 1;

        for (int i = 0; i < numChildren; i++) list.add(new Child());
        for (int i = 0; i < numTeachers; i++) list.add(new Teacher());
        for (int i = 0; i < numSoldiers; i++) list.add(new Soldier());

        System.out.println("We have " + list.size() + " survivors trying to make it to safety.");

        return list;
    }

    public static List<Zombie> generateRandomZombies() {
        Random r = new Random();
        List<Zombie> list = new ArrayList<>();

        int numCommon = r.nextInt(10) + 1;
        int numTanks = r.nextInt(3) + 1;

        for (int i = 0; i < numCommon; i++) list.add(new CommonInfected());
        for (int i = 0; i < numTanks; i++) list.add(new Tank());

        System.out.println("But there are " + list.size() + " zombies waiting for them.");

        return list;
    }

    // ============================================================
    // FIXED GROUPS (Release 2.0)
    // ============================================================
    public static List<Survivor> generateFixedSurvivors() {
        List<Survivor> list = new ArrayList<>();

        // 0 children, 3 teachers, 2 soldiers
        list.add(new Teacher());
        list.add(new Teacher());
        list.add(new Teacher());
        list.add(new Soldier());
        list.add(new Soldier());

        System.out.println("We have 5 survivors trying to make it to safety (0 children, 3 teachers, 2 soldiers)");

        return list;
    }

    public static List<Zombie> generateFixedZombies() {
        List<Zombie> list = new ArrayList<>();

        // 2 common infected, 7 tanks
        list.add(new CommonInfected());
        list.add(new CommonInfected());
        for (int i = 0; i < 7; i++) list.add(new Tank());

        System.out.println("But there are 9 zombies waiting for them (2 common infected, 7 tanks)");

        return list;
    }
}