package Class_Three;

import java.io.*;

public class BOJ_11727 { // 문제 : 2xn 타일링 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine()); // 채워야 할 가로 길이 n 입력

        int[] dp = new int[1001]; // dp 배열 선언 (문제에서 n <= 1000)

        // 초기값 설정
        dp[1] = 1; // 2x1을 채우는 방법은 세로 타일 1개
        dp[2] = 3; // 2x2를 채우는 방법은 1x2 두 개, 2x1 두 개, 2x2 한 개 총 3가지
        dp[3] = 5; // 2x3은 사전에 계산해서 초기값 설정 (문제 조건상 편의 위해 넣음)

        // 점화식 적용: dp[i] = dp[i-1] + 2*dp[i-2]
        // dp[i-1]: 마지막에 2x1 세로 타일을 붙이는 경우
        // dp[i-2]*2: 마지막 두 칸을 가로 1x2 두 개 or 2x2 정사각형으로 붙이는 경우 (두 가지 방법)
        for (int i = 4; i <= target; i++) {
            if (dp[i] == 0) {
                dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007; // 10007로 나눈 나머지를 저장 (오버플로우 방지)
            }
        }

        System.out.println(dp[target]); // 최종 결과 출력
    }
}

// 메모리 : 14416KB
// 시간 : 100ms
// 문제 링크 : https://www.acmicpc.net/problem/11727