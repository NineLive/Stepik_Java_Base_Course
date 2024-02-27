package Module6_4_3;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

public class Start {
    public static void main(String[] args) {
        String numbers = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";
        System.setIn(new ByteArrayInputStream(numbers.getBytes(StandardCharsets.UTF_8)));
        counter();
    }

    public static void counter() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> stream = reader.lines();

        Map<String, Integer> treeMap = new TreeMap<>();
        String[] strr = stream
                .flatMap((string) -> Arrays.stream(string.split("(?U)\\W+")))
                .peek(string -> {
                    if (!(treeMap.containsKey(string.toLowerCase()))) {
                        treeMap.put(string.toLowerCase(), 1);
                    } else {
                        treeMap.put(string.toLowerCase(), treeMap.get(string.toLowerCase()) + 1);
                    }
                })
                .toArray(String[]::new);

        treeMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));

    }
}
