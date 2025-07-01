package Class_Three;

import java.io.*;

public class BOJ_11726 { // 문제 : 2xn 타일링
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 입력: 타일의 길이 n (2xn 직사각형)

        int[] dp = new int[1001]; // DP 배열 선언 (문제에서 n은 최대 1000까지 가능)

        dp[1] = 1; // 2x1 직사각형을 채우는 방법: 1가지
        dp[2] = 2; // 2x2 직사각형을 채우는 방법: 세로 2개 놓기, 가로 2개 놓기 -> 2가지

        // 점화식을 이용하여 dp 배열 채우기
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007; // 이전 2개의 값을 더하고 10007로 나눈 나머지 저장
        }

        System.out.println(dp[n]); // 최종 결과 출력
    }
}

// 메모리 : 14376KB
// 시간 : 128ms
// 문제 링크 : https://www.acmicpc.net/problem/11726