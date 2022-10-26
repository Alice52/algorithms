package fundamentals.programmingmodel.test;

import java.io.PrintWriter;
import java.util.Scanner;

public class TestAverage {

    private static Scanner scanner = new Scanner(System.in);
    private static PrintWriter printWriter = new PrintWriter(System.out, true);

    public static void main(String[] args) {

        double sum = 0.0;
        int cnt = 0;
        String temp = null;

        // Should not use the scanner.hasNext() ,it is always exits.
        while (!(temp = scanner.nextLine()).equals("quit")) {
            sum += Double.parseDouble(temp);
            cnt++;
        }
        scanner.close();
        double avg = sum / cnt;
        // Format the data
        printWriter.printf("Average is %.5f\n", avg);
    }
}