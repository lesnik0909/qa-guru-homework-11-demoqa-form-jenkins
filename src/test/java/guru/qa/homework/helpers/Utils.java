package guru.qa.homework.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Utils {

  public static String formatDate(LocalDate date, String pattern, String locale) {
    return date.format(DateTimeFormatter.ofPattern(pattern, new Locale(locale)));
  }

}
