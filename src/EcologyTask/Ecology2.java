package EcologyTask;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

public class Ecology2 {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("D:\\data.csv");
        int maxConsumption = 200;
        parseEcologyUser(path, maxConsumption);
    }

    public static void parseEcologyUser(Path path, int maxConsumption) throws Exception {
        String newFileName = "dota2.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toString()));
             Scanner scanner = new Scanner(reader).useDelimiter("\\s+").useLocale(Locale.ENGLISH);
             FileWriter writer = new FileWriter(path.getParent() + newFileName)) {

            writer.write(reader.readLine() + "\n");

            while (scanner.hasNext()) {
                String string = scanner.next();
                if (isEcologicalUser(string, maxConsumption)) {
                    writer.write(string + "\n");
                }
            }
        }
    }

    public static boolean isEcologicalUser(String string, int maxConsumption) {
        String[] partsOfString = string.split("[|]");
        for (int i = 2; i < partsOfString.length; i++) {
            if (Integer.parseInt(partsOfString[i]) > maxConsumption) {
                return false;
            }
        }
        return true;
    }
}
