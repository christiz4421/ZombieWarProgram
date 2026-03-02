//Base class for melee weapons like axes and crowbars
//Useful if we want to limit certain survivors to only using melee weapons
public abstract class MeleeWeapon extends Weapon {

    public MeleeWeapon(int damage, int accuracy) {
        super(damage, accuracy);
    }
}
