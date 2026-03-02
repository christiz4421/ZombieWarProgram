import java.util.Random;

/**
 * The weapon class defines a weapon used by survivors.
 *
 * A weapon contains a name, a damage bonus that is applied on a hit, and an accuracy value.
 */
public class Weapon {

    // The name of the weapon
    private final String name;

    // Extra damage added to the survivor's base attack value when the weapon hits
    private final int damageBonus;

    // Percentage chance to hit the target, from 0.0 to 1.0 (0.75 means the weapon hits 75% of the time
    private final double accuracy;

    /**
     * Creates a weapon with the specified name, damage bonus, and accuracy.
     *
     * @param name the weapon's name
     * @param damageBonus extra damage added on a successful hit
     * @param accuracy chance to hit the target
     */
    public Weapon(String name, int damageBonus, double accuracy) {
        this.name = name;
        this.damageBonus = damageBonus;
        this.accuracy = accuracy;
    }

    // Get the weapon's name
    public String getName() {
        return name;
    }

    // Get the weapon's damage bonus
    public int getDamageBonus() {
        return damageBonus;
    }

    // Get the weapon's accuracy
    public double getAccuracy() {
        return accuracy;
    }

    /**
     * Determines whether an attack hits based on the specified weapon's accuracy.
     *
     * @param random random number generator used to roll for hit/miss
     * @return true if the attack hits and false if it misses
     */
    public boolean hits(Random random) {
        // Roll a number from 0.0 to 1.0 and compare it to accuracy
        return random.nextDouble() < accuracy;
    }
}