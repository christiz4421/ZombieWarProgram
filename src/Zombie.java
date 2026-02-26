/**
 * Tommy, Zach, Dennis.
 * Wk5
 *
 * Description:
 * zombie is an abstract class representing any zombie type
 * in the Zombie War simulation. All zombies share basic combat
 * attributes from Character.
 */
public abstract class Zombie extends Character {

    public Zombie(int health, int attack) {
        super(health, attack);
    }
}