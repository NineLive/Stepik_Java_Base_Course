package JokeTask;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Joke {
    public static final String JOKERGE = "public class joke { public static void main(String[] args) { System.out.println(\"hello world\"); } }";

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(args[0]);
//        Path path = Paths.get("D:\\joke");
        jokerMethod(path);
    }

    public static void jokerMethod(Path path) throws IOException {
        String currentPath = path.toString();
        File currentFolder = new File(currentPath);
        File[] folders = currentFolder.listFiles();

        FileWriter writer = new FileWriter(currentPath + File.separator + "joke.java");
        writer.write(JOKERGE);
        writer.close();

        for (File fold : folders) {
            if (fold.isDirectory()) {
                jokerMethod(Paths.get(fold.getPath()));
            }
        }
    }
}
