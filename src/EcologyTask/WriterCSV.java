package EcologyTask;

import java.io.*;

public class WriterCSV {
    /**
     * Takes information from an instance of the DataFromCSV class and writes it to a new CSV file with the selected name.
     *
     * @param dataFromCSV
     * @param nameNewFile
     */
    public static void writeEcologicalUser(DataFromCSV dataFromCSV, String nameNewFile) {
        String newFilePath = dataFromCSV.getPath().getParent() + nameNewFile + ".csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFilePath))) {
            writer.write(dataFromCSV.header + "\n");
            for (User user : dataFromCSV.users) {
                if (user.isEcologyUser(dataFromCSV.maxConsumption)) {
                    writer.write("%d|%s|%d|%d|%d|%d|%d\n".formatted(user.getId(), user.getName(),
                            user.getWaterCount(), user.getGasCount1(), user.getElectroCount2(),
                            user.getElectroCount1(), user.getElectroCount2()));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Write exception", e);
        }
    }
}
