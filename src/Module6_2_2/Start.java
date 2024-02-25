package Module6_2_2;

import java.util.*;

public class Start {
    public static void main(String[] args) {
        
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
        for (int j = 0; j < list.size(); j++) {
            System.out.print(list.get(j) + " ");
        }
    }
}
