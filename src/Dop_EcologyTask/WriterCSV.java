package Dop_EcologyTask;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.List;

public class WriterCSV {
    private static Path path;

    WriterCSV(Path path) {
        WriterCSV.path = path;
    }

    /**
     * Takes information from an instance of the DataFromCSV class and writes it to a new CSV file with the selected path.
     */
    public void writeNewCSV(List<User> ecoUsers) {
        String newFilePath = path.toString();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFilePath))) {
            writer.write(createHeader());

            for (User user : ecoUsers) {
                writer.write("%d|%s|%d|%d|%d|%d|%d\n".formatted(user.getId(), user.getName(),
                        user.getWaterCount(), user.getGasCount1(), user.getElectroCount2(),
                        user.getElectroCount1(), user.getElectroCount2()));
            }
        } catch (IOException e) {
            throw new RuntimeException("Write exception", e);
        }
    }

    public static String createHeader() {
        StringBuilder header = new StringBuilder();
        for (Field field : User.class.getDeclaredFields()) {
            System.out.println();
            header.append(field.getName()).append("|");
        }
        header.append("\n");
        return header.toString();
    }
}
