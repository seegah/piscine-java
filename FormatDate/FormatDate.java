import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class FormatDate {

    public static String formatToFullText(LocalDateTime dateTime) {
        if (dateTime == null) return null;
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendLiteral("Le ")
            .appendPattern("dd ")
            .appendPattern("MMM")
            .appendLiteral(" de l'an ")
            .appendPattern("yyyy à HH'h'mm'm et 'ss's'")
            .toFormatter(Locale.FRENCH);
        return dateTime.format(formatter);
    }

    public static String formatSimple(LocalDate date) {
        if (date == null) return null;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
            "MMMM dd yy",
            Locale.ITALIAN
        );
        return date.format(formatter);
    }

    public static String formatIso(LocalTime time) {
        if (time == null) return null;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return time.format(formatter);
    }
}