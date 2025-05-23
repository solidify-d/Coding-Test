package Class_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);

        int[] results = {
                a + b,
                a - b,
                a * b,
                a / b,
                a % b
        };

        for (int res : results) {
            System.out.println(res);
        }

        br.close();
    }
}

// 메모리 : 14332KB
// 시간 : 108ms