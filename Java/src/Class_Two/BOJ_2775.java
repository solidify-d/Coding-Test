package Class_Two;

import java.io.*;

public class BOJ_2775 { // 문제 : 부녀회장이 될테야
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수 입력 받기
        int repeats = Integer.parseInt(br.readLine());

        // 출력 결과를 누적하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 아파트 정보 저장용 배열 선언 (층수 0~14, 호수 1~14)
        int[][] apt = new int[15][15];

        // 0층 초기화: 0층의 i호에는 i명이 산다 (문제 조건)
        for (int i = 1; i <= 14; i++) {
            apt[0][i] = i;
        }

        // DP 테이블 채우기
        // k층 n호에는 (k-1층의 1호 ~ n호까지)의 합이 거주
        for (int k = 1; k <= 14; k++) {
            for (int n = 1; n <= 14; n++) {
                // 점화식: apt[k][n] = apt[k][n - 1] + apt[k - 1][n]
                apt[k][n] = apt[k][n - 1] + apt[k - 1][n];
            }
        }

        // 테스트 케이스 반복
        for (int i = 0; i < repeats; i++) {
            // k층
            int k = Integer.parseInt(br.readLine());
            // n호
            int n = Integer.parseInt(br.readLine());

            // 정답 누적
            sb.append(apt[k][n]).append("\n");
        }

        // 결과 한 번에 출력
        System.out.print(sb);
    }
}

// 메모리 : 13972KB
// 시간 : 100ms