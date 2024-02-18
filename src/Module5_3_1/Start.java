package Module5_3_1;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Start {
    public static final Charset CHARSET = StandardCharsets.US_ASCII;

    public static void main(String[] args) throws IOException {
        byte[] mass = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51};

        InputStream inputStream = new ByteArrayInputStream(mass);

        String result = readAsString(inputStream, CHARSET);
        System.out.println(result);
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        int currentByte = reader.read();
        StringBuilder result = new StringBuilder();
        while (currentByte != -1) {
            result.append((char) currentByte);
            currentByte = reader.read();
        }
        return result.toString();
    }

}
