package Class_Two;

import java.io.*;
import java.util.*;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 1;
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();

            while (num <= input) {
                stack.push(num++);
                sb.append("+\n");
            }

            if (stack.peek() == input) {
                stack.pop();
                sb.append("-\n");
            } else {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
