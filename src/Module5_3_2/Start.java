package Module5_3_2;

import Module5_3_1.Start1;

import java.io.*;
import java.util.Locale;

public class Start {
    public static void main(String[] args) throws IOException {
        parserSummOfNumber(System.in);
    }

    public static void parserSummOfNumber(InputStream inputStream) throws IOException {
        String string = Start1.readAsString(inputStream, Start1.CHARSET);
        String[] parts = string.split("[\\n ]");
        double summ = 0.0;
        for (String x : parts) {
            try {
                summ += Double.parseDouble(x);
            } catch (NumberFormatException e) {
            }
        }
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        writer.printf(Locale.forLanguageTag("en"), "%.6f", summ);
        writer.close();
    }
}
