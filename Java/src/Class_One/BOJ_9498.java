package Class_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9498 { // 시험 성적
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        br.close();

        if (input >= 90) {
            System.out.println("A");
        } else if (input >= 80) {
            System.out.println("B");
        } else if (input >= 70) {
            System.out.println("C");
        } else if (input >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}

// 메모리 : 14248KB
// 시간 : 136ms
// 링크 : https://www.acmicpc.net/problem/949