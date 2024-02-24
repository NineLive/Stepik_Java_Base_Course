package Module6_1;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Start {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!

        Pair<Integer, String> pair3 = Pair.of(1, "hello");
//        System.out.println(pairNullString.getFirst());
        boolean mustBeTrue2 = pair.equals(pair3); // true!
        System.out.println(i);
        System.out.println(s);
        System.out.println(mustBeTrue2);
        System.out.println(mustAlsoBeTrue);

    }
}

