package de.hawhamburg.krukenberg_benlemlih.a08.streams_io;

import java.io.*;

/**
 * @author Youssef Benlehmlih
 * @author Jonas Krukenberg
 */
public final class SerializationUtil {

    private SerializationUtil() {

    }

    public static void serialize(Object obj, String filepath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))) {
            oos.writeObject(obj);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserialize(String filepath) throws NotSerializableException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new NotSerializableException("An error occured while deserializing the file!");
    }

    public static <T extends Serializable> byte[] serializeToByteArray(T obj)
            throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(obj);
                return baos.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new NotSerializableException("An error occured while deserializing the file!");
    }


    public static Object deserializeFromByteArray(byte[] b) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(b)) {
            try (ObjectInputStream ois = new ObjectInputStream(bais)) {
                return ois.readObject();
            }
        }
    }
}
