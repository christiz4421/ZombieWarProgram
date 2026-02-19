/**
 * The Character class defines the basic combat attributes and behavior
 * shared by all survivors and zombies. It serves as an abstract base class
 * to be extended by specific types of survivors and zombies.
 */
public abstract class Character {

    /**
     * The current health of the character.
     * A character is considered dead when its health reaches zero,
     * as determined by the isAlive() method.
     */
    protected int health;

    /**
     * The amount of damage this character deals when attacking.
     */
    protected int attack;

    /**
     * Creates a character with the specified health and attack values.
     *
     * @param health the starting health of the character
     * @param attack the attack damage done by the character
     */
    public Character(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    /**
     * Checks whether the character is still alive.
     *
     * @return true if health is above 0, otherwise return false
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Attacks another character.
     * A dead character cannot attack.
     *
     * @param target the character being attacked
     */
    public void attack(Character target) {
        // Only living characters can attack
        if (isAlive()) {
            target.takeDamage(attack);
        }
    }

    /**
     * Reduces the character's health by the specified amount.
     * Health will not drop below zero.
     *
     * @param amount the amount of damage taken
     */
    public void takeDamage(int amount) {
        if (isAlive()) {
            health -= amount;

            // Prevent negative health values
            if (health < 0) {
                health = 0;
            }
        }
    }

    /**
     * Gets the character's current health.
     *
     * @return the current health value
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets the character's attack power.
     *
     * @return the attack value
     */
    public int getAttack() {
        return attack;
    }
}
