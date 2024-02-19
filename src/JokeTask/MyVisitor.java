package JokeTask;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;


public class MyVisitor extends SimpleFileVisitor<Path> {
    public static final String JOKERGE = "public class joke { public static void main(String[] args) { System.out.println(\"hello world\"); } }";
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        try(FileWriter writer = new FileWriter(dir + File.separator + "joke.java")){
            writer.write(JOKERGE);
        }
        return FileVisitResult.CONTINUE;
    }
}
