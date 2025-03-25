import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {
    public static Integer sumOfStringLength(Stream<String> s) {
        return s.mapToInt(String::length)
                .sum();
    }

    public static List<String> upperCaseAllString(Stream<String> s) {
        return s.map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static Set<Integer> uniqIntValuesGreaterThan42(Stream<Double> s) {
        return s.filter(d -> d > 42)
                .mapToInt(Double::intValue)
                .boxed()
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) throws IOException {
        System.out.println(StreamMap.sumOfStringLength(Stream.of("Bonjour", "le", "monde !")));
        System.out.println(StreamMap.upperCaseAllString(Stream.of("IL", "Fait", "beaU !!")));
        System.out.println(StreamMap.uniqIntValuesGreaterThan42(Stream.of(23.439, 42.34, 39194.4)));
    }
}