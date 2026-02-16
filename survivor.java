/**
 * Tommy, Zach, Dennis.
 * Wk5
 * 
 * Description:
 * survivor is an abstract class representing any human survivor
 * in the Zombie War simulation. All survivors share basic combat
 * attributes from Character.
 */
public abstract class survivor extends Character {

    public survivor(int health, int attack) {
        super(health, attack);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
