package Class_Two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949 { // 문제 : 균형잡힌 세상
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            // 입력이 "." 한 글자만 있을 때 종료
            if (line.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;

            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);

                // 온점(.)이 나오면 해당 줄의 검사를 끝냄
                if (ch == '.') {
                    break;
                }

                // 여는 괄호는 스택에 쌓기
                if (ch == '(' || ch == '[') {
                    stack.push(ch);

                    // 닫는 괄호가 나오면 짝 검사
                } else if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        isBalanced = false;
                        break;
                    }
                } else if (ch == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        isBalanced = false;
                        break;
                    }
                }
                // 그 외 문자(영어, 숫자, 공백 등)는 무시
            }

            // 모든 문자 처리 후에도 스택이 비어 있지 않으면 불균형
            if (!stack.isEmpty()) {
                isBalanced = false;
            }

            System.out.println(isBalanced ? "yes" : "no");
        }
        br.close();
    }
}
