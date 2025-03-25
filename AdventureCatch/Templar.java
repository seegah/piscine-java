public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character character) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        character.takeDamage(-healCapacity);
        if (character.getCurrentHealth() > character.getMaxHealth()) {
            character.takeDamage(character.getCurrentHealth() - character.getMaxHealth());
        }
    }

    @Override
    public int getShield() {
        return shield;
    }

    @Override
    public void attack(Character target) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        this.heal(this);
        int damage = (getWeapon() != null) ? getWeapon().getDamage() : 6;
        target.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        int effectiveDamage = Math.max(0, damage - shield);
        setCurrentHealth(getCurrentHealth() - effectiveDamage);
    }

    @Override
    public String toString() {
        String base = (getCurrentHealth() == 0)
                ? getName() + " has been beaten, even with its " + shield + " shield. So bad, it could heal "
                        + healCapacity + " HP"
                : getName() + " is a strong Templar with " + getCurrentHealth() + " HP. It can heal " + healCapacity
                        + " HP and has a shield of " + shield;
        return (getWeapon() != null) ? base + ". He has the weapon " + getWeapon().toString() + "." : base + ".";
    }
}