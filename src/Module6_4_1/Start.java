package Module6_4_1;

import java.util.stream.IntStream;

public class Start {
    public static void main(String[] args) {
        pseudoRandomStream(13).forEach(System.out::println);
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, number -> number * number % 10000 / 10).limit(15);
    }
}
