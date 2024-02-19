package JokeTask;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;


public class MyVisitor extends SimpleFileVisitor<Path> {
    public String textInFile;
    public static final String FILE_NAME = "joke.java";

    public MyVisitor() {
        this.textInFile = "";
    }

    public MyVisitor(String textInFile) {
        this.textInFile = textInFile;
    }

    /**
     * Before visiting the directory this method creates a file called {@link  #FILE_NAME} containing {@link  #textInFile}
     *
     * @param dir   a reference to the directory
     * @param attrs the directory's basic attributes
     * @return nothing
     * @throws IOException
     */
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        try (FileWriter writer = new FileWriter(dir + File.separator + FILE_NAME)) {
            writer.write(textInFile);
        }
        return FileVisitResult.CONTINUE;
    }
}
