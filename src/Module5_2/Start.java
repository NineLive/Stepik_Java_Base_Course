package Module5_2;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;

public class Start {
    public static void start(){
    int totalBytesWritten = 0;
    int blockSize;
    byte [] buf = new byte[1024];
    while ((blockSize = inputStream.read(buf))>0){
        outputStream.write(buf, 0, blockSize);
        totalBytesWritten += blockSize;
    }
    }


}
