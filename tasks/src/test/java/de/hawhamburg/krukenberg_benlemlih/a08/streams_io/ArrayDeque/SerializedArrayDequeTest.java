package de.hawhamburg.krukenberg_benlemlih.a08.streams_io.ArrayDeque;

import de.hawhamburg.krukenberg_benlemlih.a08.streams_io.SerializationUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Youssef Benlemlih
 * @author Jonas Krukenberg
 */
class SerializedArrayDequeTest {

    private static Serializable[] testObjects;

    @BeforeAll
    static void setup() {
        ArrayDequeSerializedForm<Integer> obj0 = new ArrayDequeSerializedForm<>(0);
        ArrayDequeSerializedForm<Double> obj1 =
                new ArrayDequeSerializedForm<>(List.of(25.99, 3.0, 4.2, Double.NaN));
        ArrayDequeSerializedForm<Boolean> obj2
                = new ArrayDequeSerializedForm<>(List.of(true, true, false));
        ArrayDequeSerializedForm<Integer> obj3
                = new ArrayDequeSerializedForm<>(List.of(2, 3, 4));
        ArrayDequeSerializedProxy<Integer> obj4 = new ArrayDequeSerializedProxy<>(0);
        ArrayDequeSerializedProxy<Double> obj5 =
                new ArrayDequeSerializedProxy<>(List.of(25.99, 3.0, 4.2, Double.NaN));
        ArrayDequeSerializedProxy<Boolean> obj6
                = new ArrayDequeSerializedProxy<>(List.of(true, true, false));
        ArrayDequeSerializedProxy<Integer> obj7
                = new ArrayDequeSerializedProxy<>(List.of(2, 3, 4));
        testObjects = new Serializable[]{
                obj0,
                obj1,
                obj2,
                obj3,
                obj4,
                obj5,
                obj6,
                obj7,
        };
    }

    @Test
    void serialisationReflexiv() throws IOException, ClassNotFoundException {
        for (Serializable testObject : testObjects) {
            byte[] bytes = SerializationUtil.serializeToByteArray(testObject);
            Object deserialized = SerializationUtil.deserializeFromByteArray(bytes);
            assertEquals(testObject, deserialized);
        }
    }
}