package Module5_4_1;

import java.io.Serializable;
import java.util.Objects;

public class Animal implements Serializable {
    private final String name;
    public final String age;
    public Animal(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }
}
