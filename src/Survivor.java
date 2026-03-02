import java.util.Random;

/**
 * Tommy, Zach, Dennis.
 * Wk5
 *
 * Description:
 * Survivor is an abstract class representing any human survivor
 * in the Zombie War simulation. All survivors share basic combat
 * attributes from Character.
 */
public abstract class Survivor extends Character {

    // Weapon assigned to the survivor
    private Weapon weapon;

    // Random generator used to determine if the weapon hits or misses
    private static final Random RANDOM = new Random();

    public Survivor(int health, int attack) {
        super(health, attack);
    }

    // Assign a weapon to a survivor
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    // Get the survivor's weapon
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Attacks another character using the survivor's weapon.
     * If the weapon hits, the attack deals base damage plus the weapon's damage bonus.
     * If the weapon misses, the attack deals only the survivor’s base attack value.
     * If no weapon is assigned, the attack uses only the survivor’s base attack value.
     *
     * @param target the character being attacked
     */
    @Override
    public void attack(Character target) {
        // Only living survivors can attack
        if (!isAlive()) {
            return;
        }

        // Use base attack value if no weapon was assigned
        if (weapon == null) {
            super.attack(target);
            return;
        }

        // Determine whether the attack hits based on the weapon's accuracy
        if (weapon.hits(RANDOM)) {
            int totalDamage = this.attack + weapon.getDamageBonus();
            target.takeDamage(totalDamage);
        } else {
            // If the weapon misses, use the base attack damage value
            super.attack(target);
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}