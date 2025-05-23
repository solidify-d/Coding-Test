package Class_Two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while (true) {
            input = br.readLine();
            String[] inputs = input.split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);

            // 종료 조건
            if (a == 0 && b == 0 && c == 0) break;

            // 세 변 정렬 후 피타고라스 판별
            int[] sides = {a, b, c};
            Arrays.sort(sides);

            if (sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2]) { // if (A**2 + B**2 = C**2) -> right
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }

        br.close();
    }
}


// 메모리 : 14116KB
// 시간 : 132ms