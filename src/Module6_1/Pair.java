package Module6_1;

import java.util.Objects;

public class Pair<T, V> {
    private final T valueT;
    private final V valueV;

    private Pair(T valueT, V valueV) {
        this.valueT = valueT;
        this.valueV = valueV;
    }

    public static <T, V> Pair<T, V> of(T valueT, V valueV) {
        return new Pair<>(valueT, valueV);
    }

    public T getFirst() {
        return valueT;
    }

    public V getSecond() {
        return valueV;
    }

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
