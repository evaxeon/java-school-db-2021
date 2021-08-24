package java8.streams_examples.homework;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Evgeny Borisov
 */
public class BlackFridayService {

    public static void printBlackFridayPerYearSorted(int startYear, int endYear) {
        Stream.iterate(LocalDate.of(startYear, 1, 1), ourdate -> ourdate.plusDays(1))
                .takeWhile(ourDate -> ourDate.getYear() <= endYear)
                .filter(ourDate -> ourDate.getDayOfWeek() == DayOfWeek.FRIDAY)
                .filter(ourDate -> ourDate.getDayOfMonth() == 13)
                .collect(Collectors.groupingBy(LocalDate::getYear, Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparing(e -> -e.getValue()))
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }
}
