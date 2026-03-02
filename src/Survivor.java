/**
 * Tommy, Zach, Dennis.
 * Wk5
 * 
 * Description:
 * survivor is an abstract class representing any human survivor
 * in the Zombie War simulation. All survivors share basic combat
 * attributes from Character.
 */
import java.util.Random;

public abstract class Survivor extends Character {

    protected Weapon weapon;
    private static Random random = new Random();

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

    //use the weapon stats for attacking
    @Override
    public void attack(Character target) {
        if (!isAlive()) {
            return;
        }

        //check if we hit based on accuracy
        int roll = random.nextInt(100);
        if (roll < weapon.getAccuracy()) {
            //add weapon damage to attack
            int totalDamage = attack + weapon.getDamage();
            target.takeDamage(totalDamage);
        }
        //missed
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
