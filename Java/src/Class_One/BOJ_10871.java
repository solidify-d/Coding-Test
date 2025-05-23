package Class_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10871 { // X보다 작은 수
    public static void main(String[] args) throws IOException {
        // 입력을 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력: N(숫자 개수), X(비교 기준)
        String[] set = br.readLine().split(" ");

        // 두 번째 줄 입력: N개의 숫자
        String[] nums = br.readLine().split(" ");

        br.close(); // 입력 스트림 닫기

        int n = Integer.parseInt(set[0]); // 숫자 개수 N
        int x = Integer.parseInt(set[1]); // 기준 숫자 X
        // String returnVal = ""; // 출력 결과 문자열 초기화
        StringBuilder sb = new StringBuilder();

        // N개의 수를 순회하며 X보다 작은 수만 문자열에 추가
        for (int i = 0; i < n; i++){
            if (Integer.parseInt(nums[i]) < x){
                // returnVal+=nums[i] + " ";
                sb.append(nums[i] + " ");
            }
        }
        // 마지막 공백 제거 후 결과 출력
        // System.out.println(returnVal.trim());
        System.out.println(sb.toString().trim());
    }
}
// 단순 문자열 연산 사용 시
// 메모리 : 251460KB
// 시간 : 356ms

// StringBuilder 사용 시
// 메모리 : 16472KB
// 시간 : 156ms
// 링크 : https://www.acmicpc.net/problem/10871