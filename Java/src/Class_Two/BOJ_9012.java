package Class_Two;

import java.io.*;
import java.util.*;

public class BOJ_9012 { // 문제 : 괄호
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int repeats = Integer.parseInt(br.readLine());

        for (int i = 0; i < repeats; i++) {
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();
            boolean isBalanced = true;

            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '(') {
                    stack.push(input.charAt(j));
                } else {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        isBalanced = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                isBalanced = false;
            }

            System.out.println(isBalanced ? "YES" : "NO");
        }
    }
}

// 메모리 : 14302KB
// 시간 : 112ms