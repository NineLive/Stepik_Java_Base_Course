package Module5_2_2;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Start {


    public static void main(String[] args) {
        byte[] mass = new byte[]{(byte) 0x00, (byte) 0x00, (byte) 0xff};
        InputStream inputStream = new ByteArrayInputStream(mass);


    }
}
