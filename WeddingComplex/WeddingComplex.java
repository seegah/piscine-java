import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class WeddingComplex {
    public static Map<String, String> createBestCouple(Map<String, List<String>> first,
            Map<String, List<String>> second) {
        Map<String, String> result = new HashMap<>();

        Map<String, List<String>> firstGroup = new HashMap<>();
        Map<String, String> secondGroup = new HashMap<>();

        for (String person : first.keySet()) {
            firstGroup.put(person, new ArrayList<>());
        }

        while (result.size() < first.size()) {
            for (String firstPerson : first.keySet()) {
                if (result.containsKey(firstPerson))
                    continue;

                List<String> preferences = first.get(firstPerson);

                for (String secondPerson : preferences) {
                    if (!firstGroup.get(firstPerson).contains(secondPerson)) {
                        firstGroup.get(firstPerson).add(secondPerson);

                        if (!secondGroup.containsKey(secondPerson)) {
                            result.put(firstPerson, secondPerson);
                            secondGroup.put(secondPerson, firstPerson);
                            break;
                        } else {
                            String currentPartner = secondGroup.get(secondPerson);
                            List<String> secondPersonPreferences = second.get(secondPerson);

                            if (secondPersonPreferences.indexOf(firstPerson) < secondPersonPreferences
                                    .indexOf(currentPartner)) {
                                result.remove(currentPartner);
                                result.put(firstPerson, secondPerson);
                                secondGroup.put(secondPerson, firstPerson);
                                break;
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}