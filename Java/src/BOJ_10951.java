package Class_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10951 { // 문제: A+B - 4
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) { // EOF까지 반복

            String[] nums = line.split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            System.out.println(a + b);
        }
    }
}
// 메모리 : 14216KB
// 시간 : 132ms
// 링크 : https://www.acmicpc.net/problem/10951