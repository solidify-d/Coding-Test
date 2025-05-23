package Class_One;

import java.util.Scanner;

public class BOJ_2562 {
    public static void main(String[] args) {
        final int TOTAL_NUMBERS = 9;
        Scanner scanner = new Scanner(System.in);

        int maxValue = Integer.MIN_VALUE;
        int position = 0;

        for (int i = 0; i < TOTAL_NUMBERS; i++) {
            int input = scanner.nextInt();

            if (input > maxValue) {
                maxValue = input;
                position = i + 1; // 1-based index
            }
        }

        System.out.println(maxValue);
        System.out.println(position);

        scanner.close();
    }
}