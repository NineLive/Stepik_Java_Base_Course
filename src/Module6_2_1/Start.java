package Module6_2_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Start {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(0, 1, 2));

        System.out.println(symmetricDifference(set1, set2));
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> union = new HashSet<>(set1);
        Set<T> intersection = new HashSet<>(set1);
        union.addAll(set2);
        intersection.retainAll(set2);
        union.removeAll(intersection);
        return union;
    }
}
