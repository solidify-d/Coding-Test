package Class_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10998 { // 문제: AxB
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        br.close();

        int A = Integer.parseInt(nums[0]);
        int B = Integer.parseInt(nums[1]);

        System.out.println(A * B);
    }
}
// 메모리 : 14228KB
// 시간 : 104ms
// 링크 : https://www.acmicpc.net/problem/10998