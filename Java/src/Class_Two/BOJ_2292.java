package Class_Two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int min = 1;
        int max = 1;
        int count = 1;
        int increment = 5;
        while (true) {
            if (min <= num && num <= max) {
                System.out.println(count);
                return;
            } else {
                min = max + 1;
                max = min + increment;
                increment += 6;
                count++;
            }
        }
    }
}

// 메모리 : 14128KB
// 시간 : 108ms
