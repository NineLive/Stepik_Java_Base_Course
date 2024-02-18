package Module5_2_2;

import java.io.*;

public class Start {
    public static final InputStream INPUT_STREAM = System.in;
    public static final OutputStream OUTPUT_STREAM = System.out;

    public static void main(String[] args) throws IOException {
        byte[] mass = new byte[]{(byte) 65, (byte) 10, (byte) 10, (byte) 10, (byte) 10, (byte) 66};
        byte[] mass2 = new byte[]{(byte) 65, (byte) 10, (byte) 13, (byte) 10, (byte) 13, (byte) 66};
        byte[] mass3 = new byte[]{};

        InputStream inputStream = new ByteArrayInputStream(mass2);

        formatterWinToUnix(INPUT_STREAM);
    }
    /**
     * The method replaces all occurrences of the pair of characters '\r' and '\n' with a single character '\n'.
     * If the input encounters a single '\r' character that is not followed by a '\n', then the '\r' character is
     * output unchanged. Characters '\r' has code 13 and '\n' has code 10
     */
    public static void formatterWinToUnix(InputStream inputStream) throws IOException {
        int[] buff = new int[2];
        int firstByte = inputStream.read();
        int nextByte;
        if (firstByte != -1) {
            buff[0] = firstByte;
            while ((nextByte = inputStream.read()) != -1) {
                buff[1] = nextByte;
                if (!((buff[0] == 13) && (buff[1] == 10))) {
                    OUTPUT_STREAM.write(buff[0]);
                }
                buff[0] = buff[1];
            }
            OUTPUT_STREAM.write(buff[0]);
        }
        OUTPUT_STREAM.flush();
    }
}
