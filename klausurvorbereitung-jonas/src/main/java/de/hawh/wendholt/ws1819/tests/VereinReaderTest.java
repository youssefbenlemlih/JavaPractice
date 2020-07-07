package de.hawh.wendholt.ws1819.tests;

import de.hawh.wendholt.ws1819.a2.donottouch.modelgenerator.GeneratorKonstanten;
import de.hawh.wendholt.ws1819.a2.donottouch.modelgenerator.VereinGenerator;
import de.hawh.wendholt.ws1819.a2.model.Verein;
import de.hawh.wendholt.ws1819.a2.modelreader.VereinReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VereinReaderTest {

    private List<Verein> generierteVereine;
    private List<Verein> geleseneVereine;

    @Before
    public void fixture() throws IOException, URISyntaxException {
        generierteVereine = VereinGenerator.generateVereine(GeneratorKonstanten.MAX_KURSE);
        geleseneVereine = VereinReader.readData();
    }

    @Test
    public void testLesen(){
        assertEquals("Gelesene und Generierte Daten stimmen nicht überein",
                generierteVereine,geleseneVereine);
    }
}
