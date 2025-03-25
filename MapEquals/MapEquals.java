import java.util.Map;

public class MapEquals {
    public static boolean areMapsEqual(Map<String, Integer> map1, Map<String, Integer> map2) {
        int counter = 0;
        for (Map.Entry<String, Integer> entry1 : map1.entrySet()) {
            for (Map.Entry<String, Integer> entry2 : map2.entrySet()) {
                if (entry1.getKey().equals(entry2.getKey()) && entry1.getValue().equals(entry2.getValue())) {
                    counter++;
                    break;
                }
            }
        }

        return counter == map1.size() && counter == map2.size();
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = Map.of("Alice", 1, "Bob", 2, "Charly", 3);
        Map<String, Integer> map2 = Map.of("Alice", 1, "Bob", 2, "Charly", 3);
        System.out.println(MapEquals.areMapsEqual(map1, map2)); // Expected Output: true

        Map<String, Integer> map3 = Map.of("Alice", 1, "Bob", 2, "Charly", 3);
        Map<String, Integer> map4 = Map.of("Alice", 1, "Bob", 2, "Emily", 3);
        System.out.println(MapEquals.areMapsEqual(map3, map4)); // Expected Output: false
    }
}