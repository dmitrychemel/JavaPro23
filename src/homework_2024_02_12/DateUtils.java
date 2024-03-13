package homework_2024_02_12;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class DateUtils {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    public static String formatDateForDisplay(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }
    
    public static String formatTimeForDisplay(LocalDate date) {
        return date.format(TIME_FORMATTER);
    }

    public static String formatDateTimeForDisplay(LocalDate date) {
        return date.format(DATE_TIME_FORMATTER);
    }
}