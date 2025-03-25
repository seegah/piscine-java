import java.util.ArrayList;
import java.util.List;

public class Galaxy {
    private static List<CelestialObject> celestialObjects;

    public Galaxy() {
        celestialObjects = new ArrayList<>();
    }

    public List<CelestialObject> getCelestialObjects() {
        return celestialObjects;
    }

    public void setCelestialObjects(List<CelestialObject> celestialObjects) {
        Galaxy.celestialObjects = celestialObjects;
    }

    public static void addCelestialObject(CelestialObject celestialObject) {
        celestialObjects.add(celestialObject);
    }
}