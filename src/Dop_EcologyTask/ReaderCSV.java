package Dop_EcologyTask;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class ReaderCSV {

    private static Path path;

    ReaderCSV(Path path) {
        ReaderCSV.path = path;
    }

    /**
     * Read data from CSV file and return ArrayList of users
     */
    public List<User> read() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toString()));
             Scanner scanner = new Scanner(reader).useDelimiter("\\s+").useLocale(Locale.ENGLISH)) {
            reader.readLine();
            while (scanner.hasNext()) {
                String string = scanner.next();
                String[] parts = string.split("\\|");
                users.add(new User(parts));
            }
        } catch (IOException e) {
            throw new RuntimeException("Read exception", e);
        }
        return users;
    }
}
