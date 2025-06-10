package Class_Two;

import java.io.*;

public class BOJ_2839 { // 문제 : 설탕 배달
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int bags = 0;
        while (N >= 0) {
            if (N % 5 == 0) {
                bags += N / 5;
                System.out.println(bags);
                return;
            }
            N -= 3;
            bags++;
        }
        System.out.println(-1);
    }
}

// 메모리 : 14192KB
// 시간 : 104ms