import java.util.Random;

/**
 * This class generates random weapons for the weapon cache.
 */
public class WeaponGenerator {

    // Only used for its static methods
    private WeaponGenerator() {
    }

    /**
     * Generates and returns a random weapon from the weapon list.
     *
     * @param random random number generator used to select a weapon
     * @return a randomly selected weapon
     */
    public static Weapon getRandomWeapon(Random random) {
        int roll = random.nextInt(7); // 0..6

        switch (roll) {
            case 0:
                return new Weapon("Shotgun", 25, 0.60);
            case 1:
                return new Weapon("Submachine gun", 15, 0.80);
            case 2:
                return new Weapon("Assault rifle", 18, 0.75);
            case 3:
                return new Weapon("Pistol", 10, 0.90);
            case 4:
                return new Weapon("Axe", 20, 0.70);
            case 5:
                return new Weapon("Crowbar", 14, 0.85);
            default:
                return new Weapon("Frying pan", 8, 0.95);
        }
    }
}