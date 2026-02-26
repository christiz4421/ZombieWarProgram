/**
 * Represents a Soldier survivor, the strongest survivor type in the simulation.
 * Soldiers start with high health and attack power and are assigned a unique ID.
 */

public class Soldier extends Survivor {

    private static final int DEFAULT_HEALTH = 100;
    private static final int DEFAULT_ATTACK = 10;

    public Soldier(int id) {
        super(DEFAULT_HEALTH, DEFAULT_ATTACK);
        this.typeName = "Soldier";
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
