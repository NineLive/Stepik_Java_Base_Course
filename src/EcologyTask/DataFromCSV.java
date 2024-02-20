package EcologyTask;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataFromCSV {
    String delimiter = "\\|";
    String header;
    Path path;
    int maxConsumption;
    ArrayList<User> users = new ArrayList<>();

    DataFromCSV(String path, int maxConsumption) {
        this.path = Paths.get(path);
        this.maxConsumption = maxConsumption;

    }

    public Path getPath() {
        return path;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
