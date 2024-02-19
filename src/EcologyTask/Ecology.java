package EcologyTask;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Ecology {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("D:\\data.csv");
        int maxConsumption = 400;

        parseEcologyUser(path, maxConsumption);
    }
/*
WORK, BUT BAD VERSION
 */
    public static void parseEcologyUser(Path path, int maxConsumption) throws Exception {
        String newNameFile = path.getFileName().toString().split("[.]")[0] + "2.csv";
        try(BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
            FileWriter writer = new FileWriter(path.getParent() + newNameFile)){

            String currentString = reader.readLine();
            writer.write(currentString + "\n");

            while ((currentString = reader.readLine()) != null) {
                String[] parts = currentString.split("[|]");
                System.out.println(Arrays.toString(parts));
                boolean flag = true;
                for (int i = 2; i < parts.length; i++) {
                    System.out.println(parts[i]);
                    if (Integer.parseInt(parts[i]) > maxConsumption) {
                        flag = false;
                    }
                }
                if (flag){
                    System.out.println(currentString);
                    writer.write(currentString + "\n");
                }
            }
        }
    }
}
