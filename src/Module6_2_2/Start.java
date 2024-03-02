package Module6_2_2;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Start {
    public static void main(String[] args) {
        String numbers = "1 2 3 4 5 6 7";
        System.setIn(new ByteArrayInputStream(numbers.getBytes(StandardCharsets.UTF_8)));

        Deque<Integer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (scanner.hasNextInt()) {
            if (i % 2 != 0) {
                queue.addFirst(scanner.nextInt());
            } else {
                scanner.next();
            }
            i++;
        }
        for (int element : queue) {
            System.out.println(element + " ");
        }
    }

    public static void main21321(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (scanner.hasNextInt()) {
            if (i % 2 != 0) {
                list.add(scanner.nextInt());
            } else {
                scanner.next();
            }
            i++;
        }
        Collections.reverse(list);
        System.out.println(list);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
