package EcologyTask;

import java.io.*;
import java.util.*;

public class ReaderCSV {
    /**
     * Read data from CSV file and initialize instance of class DataFromCSV
     * @param dataFromCSV
     */
    public static void read(DataFromCSV dataFromCSV) {
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFromCSV.getPath().toString()));
             Scanner scanner = new Scanner(reader).useDelimiter("\\s+").useLocale(Locale.ENGLISH)) {

            dataFromCSV.setHeader(reader.readLine());
            while (scanner.hasNext()) {
                String string = scanner.next();
                String[] parts = string.split(dataFromCSV.delimiter);
                dataFromCSV.users.add(new User(parts));
            }
        } catch (IOException e) {
            throw new RuntimeException("Read exception", e);
        }
    }
}
