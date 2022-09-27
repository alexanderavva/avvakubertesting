package avva.test.config;

import org.springframework.util.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;

public final class DateTimeUtils {

    public static LocalDateTime parseLocalDateTime(String input) {
        if (!StringUtils.hasText(input)) {
            return null;
        }

        TemporalAccessor temporal = DateTimeFormatter.ISO_DATE_TIME.parse(input);
        if (temporal.query(TemporalQueries.zone()) != null) {
            return ZonedDateTime.from(temporal).withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();
        } else {
            return LocalDateTime.from(temporal);
        }
    }

    public static LocalDate parseLocalDate(String input) {
        if (!StringUtils.hasText(input)) {
            return null;
        }
        return LocalDate.parse(input, DateTimeFormatter.ISO_DATE);
    }

    public static LocalTime parseLocalTime(String input) {
        if (!StringUtils.hasText(input)) {
            return null;
        }
        return LocalTime.parse(input, DateTimeFormatter.ISO_TIME);
    }
}
