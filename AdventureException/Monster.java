public class Monster extends Character {
    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    @Override
    public void attack(Character target) {
        int damage = (getWeapon() != null) ? getWeapon().getDamage() : 7;
        target.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        int reducedDamage = (int) (damage * 0.8);
        setCurrentHealth(getCurrentHealth() - reducedDamage);
    }

    @Override
    public String toString() {
        String base = (getCurrentHealth() > 0) ?
                getName() + " is a monster with " + getCurrentHealth() + " HP" :
                getName() + " is a monster and is dead";
        return (getWeapon() != null) ? base + ". He has the weapon " + getWeapon().toString() + "." : base + ".";
    }
}