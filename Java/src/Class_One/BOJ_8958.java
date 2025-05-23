package Class_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_8958 { // 문제 : OX퀴즈
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeats = Integer.parseInt(br.readLine());
        String[] inputs = new String[repeats];

        for (int i = 0; i < repeats; i++) {
            inputs[i] = br.readLine();
        }
        br.close();

        for (String line : inputs) {
            Stack<Integer> stack = new Stack<>();
            int prev = 0;

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if (c == 'O') { // 만약 index i의 char이 `O` 라면
                    int curr = prev + 1; // 이번에 push할 값은 바로 이전 값보다 1 더 큰 값
                    stack.push(curr); // 스택에 push
                    prev = curr;  // 비교용 값인 prev를 이번에 push 하는 값으로 갱신
                } else { // 만약 index i의 char이 `X` 라면
                    stack.push(0); // 0을 push
                    prev = 0; // 비교용 값인 prev를 0으로 갱신
                }
            }

            // 점수 총합 계산
            int total = 0;
            while (!stack.isEmpty()) { // 스택에 push되어 있는 값이 없을 때까지 반복문
                total += stack.pop(); // 스택에 push되어 있는 값을 pop 후 합산
            }

            System.out.println(total);
        }
    }
}


// 메모리 : 14508KB
// 시간 : 116ms
// 링크 : https://www.acmicpc.net/problem/8958