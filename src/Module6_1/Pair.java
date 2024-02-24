package Module6_1;

import java.util.NoSuchElementException;
import java.util.Objects;

public class Pair<T, V> {
    private static final Pair<?, ?> EMPTY = new Pair<>(null, null);

    /**
     * If non-null, the value; if null, indicates no value is present
     */
    private final T valueT;
    private final V valueV;

    public static <T, V> Pair<T, V> empty() {
        @SuppressWarnings("unchecked")
        Pair<T, V> t = (Pair<T, V>) EMPTY;
        return t;
    }

    private Pair(T valueT, V valueV) {
        this.valueT = valueT;
        this.valueV = valueV;
    }

    public static <T, V> Pair<T, V> of(T valueT, V valueV) {
        return new Pair<>(valueT, valueV);
    }

    public T getFirst() {
        if (valueT == null) {
            throw new NoSuchElementException("No value present");
        }
        return valueT;
    }

    public V getSecond() {
        if (valueT == null) {
            throw new NoSuchElementException("No value present");
        }
        return valueV;
    }

//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        return obj instanceof Pair<?, ?> other && Objects.equals(valueT, other.valueT) && Objects.equals(valueV, other.valueV);
//    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Pair<?, ?> pair = (Pair<?, ?>) object;
        return Objects.equals(valueT, pair.valueT) && Objects.equals(valueV, pair.valueV);
    }

    public int hashCode() {
        return Objects.hashCode(valueT) + Objects.hashCode(valueV);
    }
}
