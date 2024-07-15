package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import config.Configuration;

public class ParseDateTime {
    public static String parseDateForCsvFile(String date) {
        DateTimeFormatter form = DateTimeFormatter.ofPattern(Configuration.getDataTimeInputPattern());
        LocalDateTime dt = LocalDateTime.parse(date, form);
        return dt.format(DateTimeFormatter.ofPattern(Configuration.getDataTimeOutputPattern()));
    }
}
