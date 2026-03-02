//Base class for guns
//Useful if we want to limit certain survivors to only using firearms
public abstract class Firearm extends Weapon {

    public Firearm(int damage, int accuracy) {
        super(damage, accuracy);
    }
}
