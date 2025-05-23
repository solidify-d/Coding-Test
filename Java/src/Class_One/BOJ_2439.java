package Class_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeats = Integer.parseInt(br.readLine());
        br.close();

        for (int i = 1; i <= repeats; i++) {
            // 별 i개를 만들어 문자열로 구성
            String stars = "*".repeat(i);

            // 전체 자릿수(repeats)에 맞춰 오른쪽 정렬
            System.out.printf("%" + repeats + "s\n", stars);
        }
    }
}
// 메모리 : 16856KB
// 시간 : 196ms
// 링크 : https://www.acmicpc.net/problem/2439