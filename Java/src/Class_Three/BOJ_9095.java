package Class_Three;

import java.io.*;

public class BOJ_9095 { // 문제: 1, 2, 3 더하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int repeats = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력 받음

        int[] dp = new int[12]; // dp 배열 선언 (문제 조건상 n은 최대 11까지 가능)

        // 초기값 설정 (기본 베이스 케이스)
        dp[1] = 1; // 1을 만드는 방법: 1 => 1가지
        dp[2] = 2; // 2를 만드는 방법: 1+1, 2 => 2가지
        dp[3] = 4; // 3을 만드는 방법: 1+1+1, 1+2, 2+1, 3 => 4가지

        StringBuilder sb = new StringBuilder(); // 출력 속도 향상을 위해 StringBuilder 사용

        for (int i = 0; i < repeats; i++) { // 테스트 케이스 수만큼 반복

            int curr = Integer.parseInt(br.readLine()); // 현재 테스트 케이스 값 입력 받음

            for (int j = 4; j <= curr; j++) { // 4 이상부터 dp 값 채우기 시작
                if (dp[j] == 0) { // 아직 계산되지 않은 경우만 계산
                    dp[j] = dp[j - 3] + dp[j - 2] + dp[j - 1];
                    // 점화식: 현재 숫자를 만들 수 있는 방법 =
                    // 마지막에 1을 붙인 경우(dp[j-1]) + 2를 붙인 경우(dp[j-2]) + 3을 붙인 경우(dp[j-3])의 합
                }
            }

            sb.append(dp[curr]).append("\n"); // 현재 케이스 결과 저장
        }

        System.out.println(sb); // 전체 결과 출력
    }
}


// 메모리 : 14140KB
// 시간 : 100ms
// 문제 링크 : https://www.acmicpc.net/problem/9095