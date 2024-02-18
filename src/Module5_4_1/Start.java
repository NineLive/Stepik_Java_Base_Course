package Module5_4_1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Start {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("D:\\2.bin");
        Animal animal = new Animal("bobrkurwa", "2.5");

        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(animal);
        }
        Animal deserializedBobr;
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            deserializedBobr = (Animal) ois.readObject();

        }
        System.out.println(deserializedBobr.name);
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int size = ois.readInt();
            Animal[] result = new Animal[size];
            for (int i = 0; i < result.length; i++) {
                result[i] = (Animal) ois.readObject();
            }
            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
