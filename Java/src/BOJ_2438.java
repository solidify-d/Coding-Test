import java.util.Scanner;
import java.util.Stack;

public class BOJ_2438 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        int repeats = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < repeats; i++) {
            stack.push("*");
            for (String star : stack) {
                System.out.print(star);
            }
            System.out.println();
        }

        scanner.close();
    }
}

// 메모리 : 17968KB
// 시간 : 256ms