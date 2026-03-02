/**
 * Tommy, Zach, Dennis.
 * Wk5
 * 
 * Description:
 * survivor is an abstract class representing any human survivor
 * in the Zombie War simulation. All survivors share basic combat
 * attributes from Character.
 */
public abstract class Survivor extends Character {

    protected Weapon weapon;

    public Survivor(int health, int attack) {
        super(health, attack);
        this.weapon = new Unarmed();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
