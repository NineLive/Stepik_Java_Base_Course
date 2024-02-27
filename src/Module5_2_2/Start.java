package Module5_2_2;

import java.io.*;
import java.util.Collections;
import java.util.stream.Collectors;

public class Start {

    public static void main(String[] args) throws IOException {
        byte[] mass = new byte[]{(byte) 65, (byte) 10, (byte) 10, (byte) 10, (byte) 10, (byte) 66};
        byte[] mass2 = new byte[]{(byte) 65, (byte) 10, (byte) 13, (byte) 10, (byte) 13, (byte) 66};
        byte[] mass3 = new byte[]{};

        InputStream inputStream = new ByteArrayInputStream(mass2);
        String numbers = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";
        System.setIn(new ByteArrayInputStream(mass2));
        formatterWinToUnix();
    }

    /**
     * The method replaces all occurrences of the pair of characters '\r' and '\n' with a single character '\n'.
     * If the input encounters a single '\r' character that is not followed by a '\n', then the '\r' character is
     * output unchanged. Characters '\r' has code 13 and '\n' has code 10
     */
    public static void formatterWinToUnix() throws IOException {
        int previousValue = System.in.read();
        int currentValue;
        while (previousValue != -1) {
            currentValue = System.in.read();
            if (!(previousValue == '\r' && currentValue == '\n')) {
                System.out.write(previousValue);
            }
            previousValue = currentValue;
        }
        System.out.flush();
    }
}
