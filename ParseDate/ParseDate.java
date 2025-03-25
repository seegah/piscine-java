import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        if (stringDate == null) return null;
        return LocalDateTime.parse(stringDate);
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        if (stringDate == null) return null;
        
        // Create a formatter for French date format "lundi 25 avril 2022"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
            "EEEE dd MMMM yyyy", 
            Locale.FRENCH
        );
        return LocalDate.parse(stringDate, formatter);
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        if (stringDate == null) return null;
        
        // Custom parser for "09 heures du soir, 07 minutes et 23 secondes"
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendPattern("HH 'heures du soir', mm 'minutes et' ss 'secondes'")
            .toFormatter(Locale.FRENCH);
        
        // Parse the time and adjust for "soir" (evening) - add 12 hours if it's PM
        LocalTime time = LocalTime.parse(stringDate, formatter);
        if (stringDate.contains("soir")) {
            time = time.plusHours(12);
        }
        return time;
    }
}