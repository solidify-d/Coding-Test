package Class_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int sqSum = 0;

        for (String input : inputs) {
            int num = Integer.parseInt(input);
            sqSum += num * num;
        }

        System.out.println(sqSum % 10);
    }
}

// 메모리 : 14172KB
// 시간 : 124ms