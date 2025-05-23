package Class_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_27866 { // 문제: 문자와 문자열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int index = Integer.parseInt(br.readLine());
        br.close();
        System.out.println(word.charAt(index-1));
    }
}
// 메모리 : 14184KB
// 시간 : 104ms
// 링크 : https://www.acmicpc.net/problem/27866