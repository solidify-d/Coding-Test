package Class_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10952 { // 문제: A+B - 5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) { // EOF까지 반복
            if (line.isEmpty()) continue;
            String[] nums = line.split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            if (a == 0 && b == 0) {
                break;
            }
            System.out.println(a + b);
        }
        br.close();
    }
}
// 메모리 : 14248KB
// 시간 : 104ms
// 링크 : https://www.acmicpc.net/problem/10952