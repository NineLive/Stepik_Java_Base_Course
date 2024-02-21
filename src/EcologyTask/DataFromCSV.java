package EcologyTask;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

// Now this class is useless
@Deprecated
public class DataFromCSV {
    String delimiter = "\\|";
    String header;
    Path path;

    ArrayList<User> users = new ArrayList<>();

    DataFromCSV(String path) {
        this.path = Paths.get(path);
    }

    public Path getPath() {
        return path;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
