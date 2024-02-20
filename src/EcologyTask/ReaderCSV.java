package EcologyTask;

import java.io.*;
import java.util.*;

public class ReaderCSV {
    public static void read(DataFromCSV otchet) {
        try (BufferedReader reader = new BufferedReader(new FileReader(otchet.getPath().toString()));
             Scanner scanner = new Scanner(reader)
                     .useDelimiter("\\s+")
                     .useLocale(Locale.ENGLISH)) {

            otchet.setHeader(reader.readLine());

            while (scanner.hasNext()) {
                String string = scanner.next();
                String[] parts = string.split("\\|");
                otchet.users.add(new User(parts));
            }
        } catch (IOException e) {
            throw new RuntimeException("Read exception", e);
        }
    }
}
