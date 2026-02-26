/**
 * Represents a CommonInfected zombie, the weakest zombie type.
 * CommonInfecteds start with a mid-range health and attack power and are
 * assigned a unique ID.
 */

public class CommonInfected extends Zombie {

    private static final int DEFAULT_HEALTH = 150;
    private static final int DEFAULT_ATTACK = 20;

    public CommonInfected(int id) {
        super(DEFAULT_HEALTH, DEFAULT_ATTACK);
        this.typeName = "Tank";
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