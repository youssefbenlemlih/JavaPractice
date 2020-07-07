package de.hawh.wendholt.ws1819.a2.modelreader;

import de.hawh.wendholt.ws1819.a2.donottouch.model.Kurs;
import de.hawh.wendholt.ws1819.a2.donottouch.model.enums.Sportart;
import de.hawh.wendholt.ws1819.a2.donottouch.model.enums.VereinsName;
import de.hawh.wendholt.ws1819.a2.donottouch.modelgenerator.GeneratorKonstanten;
import de.hawh.wendholt.ws1819.a2.donottouch.utils.DateTimeUtil;
import de.hawh.wendholt.ws1819.a2.donottouch.utils.PathUtil;
import de.hawh.wendholt.ws1819.a2.model.Verein;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Gesamt: 17 Pkt
public class VereinReader {

    private static final String RESOURCE_NAME = "VereinsDaten";


    public static List<Verein> readData() throws IOException {

        List<Verein> vereine = new ArrayList<>();

        String vereineURI = Paths.get(PathUtil.getRelativePathToCompiledProjectResources() + RESOURCE_NAME).toAbsolutePath().toUri().toString();
        try (Scanner scanner = new Scanner(new URL(vereineURI).openStream().toString())) {
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] parts = line.split(GeneratorKonstanten.DELIM1);
                Verein verein = new Verein(VereinsName.fromNameString(parts[0]));
                Arrays.stream(parts)
                        .filter(s -> s.contains(GeneratorKonstanten.DELIM2))
                        .map(s -> s.split(GeneratorKonstanten.DELIM2))
                        .forEach(arr -> verein.add(new Kurs(Sportart.fromNameString(arr[0]),
                                DateTimeUtil.fromString(arr[1]),
                                DateTimeUtil.durationFromString(arr[2]),
                                Integer.parseInt(arr[3]))
                        ));
                if (verein.getKurse().size() > GeneratorKonstanten.MAX_KURSE) {
                    throw new IllegalArgumentException("Zu viele Kurse!");
                }
            }
        }
        return vereine;
    }
}
