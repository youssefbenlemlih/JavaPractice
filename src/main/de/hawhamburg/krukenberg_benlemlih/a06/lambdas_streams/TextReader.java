package src.main.de.hawhamburg.krukenberg_benlemlih.a06.lambdas_streams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A class that reads a file and counts the word occurrences in the given file
 * @author Jonas Krukenberg
 * @author Youssef Benlemlih
 */
public class TextReader {
    public static Map<String, Integer> countWordsInFile(String filename) throws IOException {
            String text = Files.readString(Paths.get(filename));
        return Stream.of(text.split("\\W+"))
                .collect(Collectors.toMap(word -> word, count -> 1, Integer::sum));
    }
}
