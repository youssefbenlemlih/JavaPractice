package de.hawhamburg.krukenberg_benlemlih.a08.streams_io.MyDeque;

import de.hawhamburg.krukenberg_benlemlih.a08.streams_io.SerializationUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.NotSerializableException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Youssef Benlemlih
 * @author Jonas Krukenberg
 */
class MyDequeSerializedProxyTest {

    @Test
    void testSerialization() {
        MyDequeSerializedProxy<String> deque = new MyDequeSerializedProxy<>(List.of("one", "two", "three"));

        URL url = getClass().getClassLoader().getResource("serialized.txt");
        assertNotNull(url);
        String filepath = url.getFile();

        SerializationUtil.serialize(deque, filepath);

        MyDeque<String> newDeque = null;
        try {
            //noinspection unchecked
            newDeque = (MyDeque<String>) SerializationUtil.deserialize(filepath);
        } catch (ClassCastException | NotSerializableException e) {
            Assertions.fail("Deserialization failed!");
        }

        assertNotNull(newDeque);
        assertEquals(deque, newDeque);
    }
}