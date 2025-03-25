import java.util.ArrayList;
import java.util.List;

public class Character {
    private final int maxHealth;  
    private int currentHealth;
    private final String name;    
    private static List<Character> allCharacters = new ArrayList<>();

    public Character(String name, int maxHealth) {
        this.currentHealth = maxHealth;
        this.maxHealth = maxHealth;
        this.name = name;
        allCharacters.add(this);
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return (getCurrentHealth() == 0) ?
                String.format("%s : KO", getName()) :
                String.format("%s : %d/%d", getName(), getCurrentHealth(), getMaxHealth());
    }

    public void takeDamage(int damage) {
        this.currentHealth = Math.max(0, getCurrentHealth() - damage);
    }

    public void attack(Character target) {
        target.takeDamage(9);
    }

    public static String printStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------------------\n");
        if (allCharacters.isEmpty()) {
            sb.append("Nobody's fighting right now !\n");
        } else {
            sb.append("Characters currently fighting :\n");
            for (Character character : allCharacters) {
                sb.append(String.format(" - %s", character.toString())).append("\n");
            }
        }
        sb.append("------------------------------------------\n");
        return sb.toString();
    }

    public static Character fight(Character character1, Character character2) {
        while (character1.getCurrentHealth() > 0 && character2.getCurrentHealth() > 0) {
            character1.attack(character2);
            if (character2.getCurrentHealth() == 0) {
                return character1;
            }
            character2.attack(character1);
            if (character1.getCurrentHealth() == 0) {
                return character2;
            }
        }
        return null;
    }
}