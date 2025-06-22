package Class_Three;

import java.io.*;

public class BOJ_9461 { // 문제 : 파도반 수열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // DP 배열 선언 (1~100까지 인덱스 사용, 값이 커질 수 있으므로 long 타입 사용)
        long[] dp = new long[101];

        // 파도반 수열 초기값 설정 (문제에서 주어진 값)
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        // 테스트 케이스 개수 입력
        int repeats = Integer.parseInt(br.readLine());

        // 결과 출력을 위한 StringBuilder 사용
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 반복
        for (int i = 0; i < repeats; i++) {
            int curr = Integer.parseInt(br.readLine()); // 현재 테스트 케이스의 N 값 입력

            // N이 3 이하일 경우, 초기값 그대로 출력
            if (curr < 4) {
                sb.append(dp[curr]).append("\n");
                continue;
            }

            // 아직 계산되지 않은 dp 값이 있다면 계산 수행
            for (int j = 4; j <= curr; j++) {
                if (dp[j] == 0) { // 아직 계산되지 않은 경우에만 수행 (메모이제이션)
                    dp[j] = dp[j - 2] + dp[j - 3];
                }
            }

            // 결과 저장
            sb.append(dp[curr]).append("\n");
        }

        // 최종 결과 출력
        System.out.println(sb);
    }
}

// 메모리 : 14108KB
// 시간 : 104ms