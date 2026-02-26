/**
 * Represents a Child survivor, the weakest survivor type in the simulation.
 * Teachers start with low health and attack power and are assigned a unique ID.
 */

public class Child extends Survivor {

    private static final int DEFAULT_HEALTH = 20;
    private static final int DEFAULT_ATTACK = 2;

    public Child (int id) {
        super(DEFAULT_HEALTH, DEFAULT_ATTACK);
        this.typeName = "Child";
        this.id = id;
    }

    /**
     * Returns the display name for this character, combining its type and ID
     * for use in battle logs.
     */
    @Override
    public String toString() {
        return typeName + " " + id;
    }
}