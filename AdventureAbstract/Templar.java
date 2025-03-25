public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    public void takeDamage(int damage) {
        setCurrentHealth(Math.max(0, getCurrentHealth() - Math.max(0, damage - this.shield)));
    }

    public void attack(Character target) {
        this.heal(this);
        target.takeDamage(6);
    }

    @Override
    public void heal(Character character) {
        character.setCurrentHealth(Math.min(character.getMaxHealth(), character.getCurrentHealth() + this.healCapacity));
    }

    @Override
    public int getHealCapacity() {
        return this.healCapacity;
    }

    @Override
    public int getShield() {
        return this.shield;
    }

    @Override
    public String toString() {
        return (super.getCurrentHealth() == 0) ?
                String.format("%s has been beaten, even with its %d shield. So bad, it could heal %d HP.", super.getName(), this.getShield(), this.getHealCapacity()) :
                String.format("%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d.", super.getName(), super.getCurrentHealth(), this.getHealCapacity(), this.getShield());
    }

    public static void main(String[] args) {
        Templar alistair = new Templar("Alistair", 20, 5, 4);
        Templar roderick = new Templar("Roderick", 10, 3, 2);

        Character.fight(alistair, roderick);

        alistair.heal(alistair);

        System.out.println(Character.printStatus());
    }
}