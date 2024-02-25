package Module6_4_1;

import java.util.stream.IntStream;

public class Start {
    public static void main(String[] args) {
        pseudoRandomStream(13).forEach(System.out::println);
        System.out.println(mid(169));
    }

    public static IntStream pseudoRandomStream(int seed) {

//        return IntStream.iterate(seed, n -> mid(n)).limit(15); // your implementation here
        return IntStream.iterate(seed, number -> {number *= number;
            int d = number / 10 % 10;
            int s = number % 1000 / 100;
            int t = number % 10000 / 1000;
            return d + s * 10 + t * 100;}).limit(15);
    }

    public static int mid(int number) {
        number *= number;
        int d = number / 10 % 10;
        int s = number % 1000 / 100;
        int t = number % 10000 / 1000;
//        int result = d + s * 10 + t * 100;
        return d + s * 10 + t * 100;
    }
}
