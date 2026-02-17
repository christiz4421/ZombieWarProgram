public abstract class Character {
    private final String type;
    private final int attack;
    private int health;

    protected Character(String type, int health, int attack) {
        this.type = type;
        this.health = health;
        this.attack = attack;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        if (damage <= 0 || !isAlive()) {
            return;
        }
        health = Math.max(0, health - damage);
    }

    public void attack(Character target) {
        if (!isAlive() || !target.isAlive()) {
            return;
        }
        target.takeDamage(attack);
    }

}
