package Module5_3_2;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        parserSummOfNumber(System.in);
    }

    public static void parserSummOfNumber(InputStream inputStream) {
        double summ = 0.0;
        Scanner scanner = new Scanner(inputStream)
                .useDelimiter("[\\n ]")
                .useLocale(Locale.forLanguageTag("en"));
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                summ += scanner.nextDouble();
            } else {
                scanner.next();
            }
        }
        System.out.printf("%.6f", summ);
    }
}
