package Class_One;

import java.util.Scanner;

public class BOJ_31403 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstInput = scanner.nextLine();
        String secondInput = scanner.nextLine();
        int thirdInput = Integer.parseInt(scanner.nextLine());

        System.out.println(Integer.parseInt(firstInput) + Integer.parseInt(secondInput) - thirdInput);
        System.out.println((Integer.parseInt(firstInput + secondInput)) - thirdInput);
    }
}