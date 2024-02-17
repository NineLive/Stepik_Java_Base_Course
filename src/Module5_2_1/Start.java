package Module5_2_1;

import java.io.*;


public class Start {
    public static void start() throws IOException {
        byte[] mass = new byte[]{(byte) 0x00, (byte) 0x00, (byte) 0xff};
        InputStream inputStream = new ByteArrayInputStream(mass);

        System.out.println(Start.checkSumOfStream(inputStream));
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int controlSumm = 0;
        int bn;
        while ((bn = inputStream.read()) != -1) {
            controlSumm = Integer.rotateLeft(controlSumm, 1) ^ (bn & 0xff);
        }
        return controlSumm;
    }
}
