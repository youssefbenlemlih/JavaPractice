package de.hawh.kahlbrandt.ss2019bai2pm2exam.test;

import de.hawh.kahlbrandt.ss2019bai2pm2exam.A01;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestWordCount {

/**
 * Tests some values (highest, non existence) in the returned map.
 */
	@Test
	void test() throws IOException {
		Map<String, Long> frequencies = A01.wordFrequency("klausurvorbereitung-youssef/src/main/java/de/hawh/kahlbrandt/ss2019bai2pm2exam/data/picasso.txt");
		assertEquals(1, frequencies.get("juan"));
		assertEquals(7, frequencies.get("der"));
		assertEquals(3, frequencies.get("picasso"));
		assertNull(frequencies.get("Picasso"));
		assertNull(frequencies.get("Gernhardt"));
	}

}
