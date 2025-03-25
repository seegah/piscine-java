import java.util.Objects;

public class CelestialObject {
    public static final double KM_IN_ONE_AU = 150_000_000d;

    private double x;
    private double y;
    private double z;
    private String name;
    private int mass;

    public CelestialObject() {
        this.mass = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.name = "Soleil";
    }

    public CelestialObject(String name, double x, double y, double z, int mass) {
        this.mass = mass;
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static double getDistanceBetween(CelestialObject c1, CelestialObject c2) {
        double dx = c2.getX() - c1.getX();
        double dy = c2.getY() - c1.getY();
        double dz = c2.getZ() - c1.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static double getDistanceBetweenInKm(CelestialObject c1, CelestialObject c2) {
        return getDistanceBetween(c1, c2) * KM_IN_ONE_AU;
    }

    @Override
    public String toString() {
        return String.format("%s is positioned at (%.3f, %.3f, %.3f)", name , x, y, z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CelestialObject that = (CelestialObject) o;
        return Double.compare(x, that.x) == 0
                && Double.compare(y, that.y) == 0
                && Double.compare(z, that.z) == 0
                && Objects.equals(name, that.name)
                && Objects.equals(mass, that.mass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, name, mass);
    }
}