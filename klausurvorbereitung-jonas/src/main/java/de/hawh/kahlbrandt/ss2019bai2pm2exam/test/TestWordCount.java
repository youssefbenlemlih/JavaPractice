package de.hawh.kahlbrandt.ss2019bai2pm2exam.test;

import de.hawh.kahlbrandt.ss2019bai2pm2exam.A01;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestWordCount {

/**
 * Tests some values (highest, non existence) in the returned map.
 */
	@Test
	void test() {
		Map<String, Long> frequencies = A01.wordFrequency("src/main/java/de/jonas/ss19/data/picasso.txt");
		assertEquals(1, frequencies.get("juan"));
		assertEquals(7, frequencies.get("der"));
		assertEquals(3, frequencies.get("picasso"));
		assertNull(frequencies.get("Picasso"));
		assertNull(frequencies.get("Gernhardt"));
	}

}
