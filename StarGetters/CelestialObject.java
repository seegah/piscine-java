public class CelestialObject {
    private double x;
    private double y;
    private double z;
    private String name;
    
    public CelestialObject() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.name = "Soleil";
    }
    
    public CelestialObject(String name, double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }
    
    // Getters and setters for x
    public double getX() {
        return this.x;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    // Getters and setters for y
    public double getY() {
        return this.y;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    // Getters and setters for z
    public double getZ() {
        return this.z;
    }
    
    public void setZ(double z) {
        this.z = z;
    }
    
    // Getters and setters for name
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}