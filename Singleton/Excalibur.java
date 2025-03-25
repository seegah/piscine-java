public class Excalibur {
    private static final Excalibur INSTANCE = new Excalibur("Sword");
    
    // Instance variable
    private final String name;
    
    // Private constructor to prevent instantiation from outside
    private Excalibur(String name) {
        this.name = name;
    }
    
    // Public method to get the singleton instance
    public static Excalibur getInstance() {
        return INSTANCE;
    }
    
    // Getter for the name property
    public String getName() {
        return name;
    }
}