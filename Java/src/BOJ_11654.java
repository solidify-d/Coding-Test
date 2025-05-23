package Class_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11654 { // 문제: 아스키 코드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nums = br.readLine();
        br.close();
        System.out.println((int) nums.charAt(0));
    }
}
// 메모리 : 14200KB
// 시간 : 104ms
// 링크 : https://www.acmicpc.net/problem/11654