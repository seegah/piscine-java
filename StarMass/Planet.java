import java.util.Objects;

public class Planet extends CelestialObject {
    private Star centerStar;

    public Planet() {
        super();
        this.centerStar = new Star();
    }

    public Planet(String name, double x, double y, double z, Star centerStar, int mass) {
        super(name, x, y, z, mass);
        this.centerStar = centerStar;
    }

    public Star getCenterStar() {
        return centerStar;
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Planet planet = (Planet) o;
        return Objects.equals(getCenterStar(), planet.getCenterStar());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCenterStar());
    }

    @Override
    public String toString() {
        return String.format("%s circles around %s at the %.3f AU", getName(), centerStar.getName(), getDistanceBetweenInKm(this, centerStar) / KM_IN_ONE_AU);
    }
}