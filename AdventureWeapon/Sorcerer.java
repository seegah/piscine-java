public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character character) {
        character.takeDamage(-healCapacity);
        if (character.getCurrentHealth() > character.getMaxHealth()) {
            character.takeDamage(character.getCurrentHealth() - character.getMaxHealth());
        }
    }

    @Override
    public void attack(Character target) {
        this.heal(this);
        int damage = (getWeapon() != null) ? getWeapon().getDamage() : 10;
        target.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        setCurrentHealth(getCurrentHealth() - damage); // Use setter
    }

    @Override
    public String toString() {
        String base = (getCurrentHealth() == 0) ?
                getName() + " is a dead sorcerer. So bad, it could heal " + healCapacity + " HP" :
                getName() + " is a sorcerer with " + getCurrentHealth() + " HP. It can heal " + healCapacity + " HP";
        return (getWeapon() != null) ? base + ". He has the weapon " + getWeapon().toString() + "." : base + ".";
    }
}