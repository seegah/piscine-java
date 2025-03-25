public class Monster extends Character {
    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    public void takeDamage(int damage) {
        setCurrentHealth(Math.max(0, getCurrentHealth() - (int) Math.floor(damage * 0.8)));
    }

    public void attack(Character target) {
        target.takeDamage(7);
    }

    @Override
    public String toString() {
        return (getCurrentHealth() == 0) ?
                String.format("%s is a monster and is dead", getName()) :
                String.format("%s is a monster with %d HP", getName(), getCurrentHealth());
    }
}