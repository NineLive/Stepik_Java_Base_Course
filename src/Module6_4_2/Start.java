package Module6_4_2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Start {
    public static void main(String[] args) {
        Integer[] ints = {13, 16, 25, 62, 384, 745, 502, 200};
        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);
        BiConsumer<Integer, Integer> biConsumer = (t, u) -> System.out.println(t + " " + u);

        findMinMax(Arrays.stream(ints), comparator, biConsumer);

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        Stream.Builder<T> builder = Stream.builder();
        Optional<? extends T> min = stream.peek(builder::add).min(order);
        Optional<? extends T> max = builder.build().max(order);

        if (!min.isPresent()) {
            minMaxConsumer.accept(null, null);
            return;
        }
        minMaxConsumer.accept(min.get(), max.get());
    }
}
