package de.hawhamburg.krukenberg_benlemlih.a08.streams_io.textstreams;

import de.hawhamburg.krukenberg_benlemlih.a08.streams_io.RunnableUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextReader {

    /**
     * @param filename relative path to the file with resources/TextReader folder as root
     */
    public Stream<String> readFile(String filename) {

        try (Scanner scanner = new Scanner(new File(getResourcePath(filename)))) {
            return scanner.useDelimiter("\\W+")
                    .tokens();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.empty();
    }

    public String[] fileToArray(String filename) {
        try (Scanner scanner = new Scanner(new File(getResourcePath(filename)))) {
            return scanner.useDelimiter("\\W+")
                    .tokens()
                    .toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[0];
    }

    public ArrayList<String> fileToArrayList(String filename) {
        try (Scanner scanner = new Scanner(new File(getResourcePath(filename)))) {
            return scanner.useDelimiter("\\W+")
                    .tokens()
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public LinkedList<String> fileToLinkedList(String filename) {
        try (Scanner scanner = new Scanner(new File(getResourcePath(filename)))) {
            return scanner.useDelimiter("\\W+")
                    .tokens()
                    .collect(Collectors.toCollection(LinkedList::new));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new LinkedList<>();
    }

    public static Map<String, Integer> wordCountSerial(Stream<String> words) {
        Map<String, Integer> wordCounts = new HashMap<>();
        words.forEach(word -> wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1));
        return wordCounts;
    }

    public static Map<String, Integer> wordCountParallel(Stream<String> words) {
        Map<String, Integer> wordCounts = new HashMap<>();
        words.parallel()
                .forEach(word -> wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1));
        return wordCounts;
    }

    public String getResourcePath(String filename) throws FileNotFoundException {
        URL url = getClass().getClassLoader().getResource(getClass().getSimpleName() + "/" + filename);
        if (url != null) {
            return url.getFile();
        } else {
            throw new FileNotFoundException(filename + " not found!");
        }
    }

    public static void main(String[] args) {
        TextReader textReader = new TextReader();

        System.out.println("\nWith Array:");
        RunnableUtils.outputDuration(()-> wordCountSerial(Arrays.stream(textReader.fileToArray("lorem.txt"))),
            "wordCountSerial");
        RunnableUtils.outputDuration(()-> wordCountParallel(Arrays.stream(textReader.fileToArray("lorem.txt"))),
            " wordCountParallel");

        System.out.println("\nWith ArrayList:");
        RunnableUtils.outputDuration(()-> wordCountSerial(textReader.fileToArrayList("lorem.txt").stream()),
            " wordCountSerial");
        RunnableUtils.outputDuration(()-> wordCountParallel(textReader.fileToArrayList("lorem.txt").stream()),
            " wordCountParallel");

        System.out.println("\nWith LinkedList:");
        RunnableUtils.outputDuration(()-> wordCountSerial(textReader.fileToLinkedList("lorem.txt").stream()),
            " wordCountSerial");
        RunnableUtils.outputDuration(()-> wordCountSerial(textReader.fileToLinkedList("lorem.txt").stream()),
            " wordCountParallel");
    }
}
