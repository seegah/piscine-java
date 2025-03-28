import java.util.Objects;

public class Star extends CelestialObject {
    private double magnitude;

    public Star() {
        super();
        this.magnitude = 0;
    }

    public Star(String name, double x, double y, double z, double magnitude, int mass) {
        super(name, x, y, z, mass);
        this.magnitude = magnitude;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Star star = (Star) o;
        return Double.compare(getMagnitude(), star.getMagnitude()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMagnitude());
    }

    @Override
    public String toString() {
        return String.format("%s shines at the %.3f magnitude", getName(), getMagnitude());
    }
}