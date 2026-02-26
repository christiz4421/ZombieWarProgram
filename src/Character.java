/**
 * The Character class defines the basic combat attributes and behavior
 * shared by all survivors and zombies. It serves as an abstract base class
 * to be extended by specific types of survivors and zombies.
 */
public abstract class Character {

    /** The current health of the character.
     * A character is considered dead when its health reaches zero,
     * as determined by the isAlive() method.
     */
    protected int health;

    /** The amount of damage this character deals when attacking.
     */
    protected int attack;

    /** The type name of the character
     */
    protected String typeName;

    /** A unique ID assigned within each character type.
     */
    protected int id;

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

    /** Returns a formatted label such as "Soldier 1" or "Tank 3".
     */
    public String getLabel() {
        return typeName + " " + id;
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
     * Attacks another character. If the attack kills the target,
     * a kill message is printed.
     */
    public void attack(Character target) {
        if (!isAlive() || !target.isAlive()) {
            return;
        }

        int before = target.health;
        target.takeDamage(attack);

        // Print kill log if the target died from this attack
        if (before > 0 && !target.isAlive()) {
            System.out.println(getLabel() + " killed " + target.getLabel());
        }
    }

    /**
     * Reduces the character's health by the specified amount.
     * Health will not drop below zero
     *
     * @param amount the amount of damage taken
     */
    public void takeDamage(int amount) {
        if (isAlive()) {
            health -= amount;
            if (health < 0) {
                health = 0;
            }
        }
    }

    /**
     * Gets the character's current health
     *
     * @return the current health value
     */
    public int getHealth() {
        return health;
    }

    /** Gets the character's attack power.
     *
     * @return the attack value
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Returns a readable name for this character that combines its type and unique ID.
     * Used when printing battle events.
     */
    @Override
    public String toString() {
        return typeName + " " + id;
    }

}

