public class Monster extends Character {
    public Monster(String name, int maxHealth) {
        super(name, maxHealth); // Call the parent Character constructor
    }

    @Override
    public String toString() {
        if (getCurrentHealth() > 0) {
            return getName() + " is a monster with " + getCurrentHealth() + " HP";
        } else {
            return getName() + " is a monster and is dead";
        }
    }
}