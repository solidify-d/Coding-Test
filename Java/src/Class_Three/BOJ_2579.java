package Class_Three;

import java.util.*;
import java.io.*;

public class BOJ_2579 { // 문제 : 계단 오르기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int repeats = Integer.parseInt(br.readLine());
        int[] dp = new int[repeats + 1];
        int[] stairs = new int[repeats + 1];

        for (int i = 1; i <= repeats; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (repeats >= 1) dp[1] = stairs[1];
        if (repeats >= 2) dp[2] = stairs[1] + stairs[2];
        if (repeats >= 3) dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);

        if (repeats <= 3) {
            System.out.println(dp[repeats]);
            return;
        }

        for (int i = 4; i <= repeats; i++) {
            dp[i] = Math.max(dp[i - 3] + stairs[i - 1] + stairs[i],
                             dp[i - 2] + stairs[i]);
        }

        System.out.println(dp[repeats]);
    }
}

// 메모리 : 14180KB
// 시간 : 100ms
// 문제 링크 : https://www.acmicpc.net/problem/2579