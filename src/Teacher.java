/**
 * Represents a Teacher survivor, the mid-range survivor type in the simulation.
 * Teachers start with mid-range health and attack power and are assigned a unique ID.
 */

public class Teacher extends Survivor {

    private static final int DEFAULT_HEALTH = 50;
    private static final int DEFAULT_ATTACK = 5;

    public Teacher(int id) {
        super(DEFAULT_HEALTH, DEFAULT_ATTACK);
        this.typeName = "Teacher";
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