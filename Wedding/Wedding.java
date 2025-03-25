import java.util.*;

public class Wedding {
    public static Map<String, String> createCouple(Set<String> first, Set<String> second) {
        List<String> firstList = new ArrayList<>(first);
        List<String> secondList = new ArrayList<>(second);

        Collections.shuffle(firstList);
        Collections.shuffle(secondList);

        Map<String, String> couple = new HashMap<>();

        int size = Math.min(firstList.size(), secondList.size());

        for (int i = 0; i < size; i++) {
            couple.put(firstList.get(i), secondList.get(i));
        }

        return couple;
    }
}