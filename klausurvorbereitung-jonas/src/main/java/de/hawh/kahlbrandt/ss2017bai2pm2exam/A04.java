package de.hawh.kahlbrandt.ss2017bai2pm2exam;

import de.hawh.kahlbrandt.ss2017bai2pm2exam.test.QueueTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public final class A04 {

    private A04() {

    }

    private static void printImportCount() {
        try (Scanner scanner = new Scanner(new File("C:/Users/Jonas/IntelliJProjects/java-exercises/klausurvorbereitung-jonas/src/main/java/de/hawh/kahlbrandt/ss2017bai2pm2exam/test/QueueTest.java"))) {
            long importCount = scanner.useDelimiter("\\W+")
                    .tokens()
                    .filter(w -> w.equals("import"))
                    .count();
            System.out.println("Die Datei enthält " + importCount + " import Statements");
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) {

        printImportCount();

        long annotationCount = Arrays.stream(QueueTest.class.getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(Test.class))
                .count();
        System.out.println("Test-Methoden: " + annotationCount);
    }
}
