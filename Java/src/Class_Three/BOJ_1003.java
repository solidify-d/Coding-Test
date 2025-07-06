package Class_Three;

import java.io.*;

public class BOJ_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int repeats = Integer.parseInt(br.readLine());
        int[] inputs = new int[repeats];
        int maxN = 0;

        // 입력 먼저 모두 받기
        for (int i = 0; i < repeats; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
            if (inputs[i] > maxN) {
                maxN = inputs[i];
            }
        }

        // DP 테이블 선언 및 초기값
        int[][] dp = new int[maxN + 1][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        if (maxN >= 1) {
            dp[1][0] = 0;
            dp[1][1] = 1;
        }

        // 점화식으로 dp 채우기
        for (int i = 2; i <= maxN; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int n : inputs) {
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }
        System.out.println(sb);
    }
}