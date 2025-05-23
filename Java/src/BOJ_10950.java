package Class_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10950 { // 문제: A+B - 3
    public static void main(String[] args) throws IOException {
        // 입력을 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // repeats 만큼 반복 수행
        int repeats = Integer.parseInt(br.readLine());

        // A + B 연산 후 출력
        for(int i = 0; i < repeats; i++){
            String[] nums = br.readLine().split(" ");
            System.out.println(Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]));
        }
    }
}

// 메모리 : 14272KB
// 시간 : 140ms
// 링크 : https://www.acmicpc.net/problem/10950