package de.hawhamburg.krukenberg_benlemlih.a06.lambdas_streams;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("E dd.MM.yyyy");

        System.out.println("============================= 1. =============================");

        MagicDatesStreams.printFirstBinaryPalindromeYear(Year.of(200));
        MagicDatesStreams.printFirstBinaryPalindromeYear(Year.of(1200));

        System.out.println("============================= 2. =============================");

        System.out.println("Friday 13th dates (10)");
        MagicDatesStreams.getFriday13Dates(LocalDate.now(), 10).forEach(date -> System.out.println(date.format(dateFormat)));
        System.out.println("Friday 13th dates until next year");
        MagicDatesStreams.getFriday13Dates(LocalDate.now(), LocalDate.now().plusYears(1)).forEach(date -> System.out.println(date.format(dateFormat)));

        System.out.println("============================= 3. =============================");

        System.out.println(
                TextReader.countWordsInFile(
                        "src/main/de/hawhamburg/krukenberg_benlemlih/a06/lambdas_streams/example.txt")
        );
        System.out.println(
                TextReader.countWordsInFile(
                        "src/main/de/hawhamburg/krukenberg_benlemlih/a06/lambdas_streams/lorem.txt")
        );

        System.out.println("============================= 5. =============================");

        Stream<Integer> integerStream = Stream.of(1, 2);
        System.out.println("Stream<Integer> (wrapper classes): ");
        integerStream.forEach(i -> System.out.print(i.getClass().getName() + " "));
//        integerStream.sum(); Gibt es hier nicht
        System.out.println("\nIntStream (only primitive types): ");
        IntStream.of(1, 2).forEach(i -> System.out.print(i + " "));
        System.out.println("aggregate function for IntStream (sum): " + IntStream.of(1, 2).sum());
    }
}
