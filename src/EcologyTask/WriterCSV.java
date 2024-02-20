package EcologyTask;

import java.io.*;
import java.util.*;

public class WriterCSV {
    public static void writeEcologicalUser(DataFromCSV otchet, String nameNewFile) {
        String newFilePath = otchet.getPath().getParent() + nameNewFile + ".csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFilePath))) {
            writer.write(otchet.header + "\n");
            for (User user : otchet.users) {
                if (user.isEcologyUser(otchet.maxConsumption)) {
                    writer.write("%d|%s|%d|%d|%d|%d|%d\n".formatted(user.getId(), user.getName(),
                            user.getWaterCount(), user.getGasCount1(), user.getElectroCount2(),
                            user.getElectroCount1(), user.getElectroCount2()));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Read exception", e);
        }
        System.out.println("создали ноый файл ");
    }
}
