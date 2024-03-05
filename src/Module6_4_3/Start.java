package Module6_4_3;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Start {
    public static void main(String[] args) {
        String numbers = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";
        System.setIn(new ByteArrayInputStream(numbers.getBytes(StandardCharsets.UTF_8)));
        counter();
    }

    public static void counter() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> streamOfStrings = reader.lines();
        streamOfStrings
                .flatMap(string -> Arrays.stream(string.split("(?U)\\W+")))
                .map(String::toLowerCase)
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }
}
