//Weapon is the base class for all weapons
//Has damage and accuracy stats
public abstract class Weapon {

    protected int damage;
    protected int accuracy;

    public Weapon(int damage, int accuracy) {
        this.damage = damage;
        this.accuracy = accuracy;
    }

    public int getDamage() {
        return damage;
    }

    public int getAccuracy() {
        return accuracy;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
