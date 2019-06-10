package fundamentals.programmingmodel.test;

import java.util.Scanner;

public class Scanner_block {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int sum = 0;
        String temp = null;

        while (!(temp = input.nextLine()).equals("quit")) {
            sum += Integer.valueOf(temp).intValue();
        }

        System.out.println("SUM: " + sum);
        input.close();
    }
}