package Class_Three;

import java.util.*;
import java.io.*;

public class BOJ_11659 { // 문제 : 구간 합 구하기 4
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력: N(숫자의 개수), M(구간 합을 구해야 하는 횟수)
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 두 번째 줄 입력: N개의 숫자 배열
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 누적 합 배열(prefix sum) 생성
        int[] sums = new int[inputs[0] + 1];

        // 누적 합 계산: sums[i] = 1번째부터 i번째까지의 합
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        // 결과 출력을 위한 StringBuilder 사용
        StringBuilder sb = new StringBuilder();

        // M개의 구간 합 계산 요청 처리
        for (int i = 0; i < inputs[1]; i++) {
            // 각 구간의 시작과 끝 인덱스 입력 (1-based index)
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // 시작과 끝이 같은 경우는 그냥 해당 숫자 출력
            if (temp[0] == temp[1]) {
                sb.append(nums[temp[0] - 1]).append("\n");
                continue;
            }

            int appendVal;

            // 시작 인덱스가 1이 아닌 경우 (누적합 배열을 활용한 일반적인 구간 합)
            if (temp[0] != 1) {
                appendVal = sums[temp[1]] - sums[temp[0] - 1];
            } else { // 시작이 1인 경우 (sums[temp[1]] 그대로 사용)
                appendVal = sums[temp[1]];
            }

            sb.append(appendVal).append("\n");
        }

        // 최종 결과 출력
        System.out.println(sb);
    }
}

// 메모리 : 85164KB
// 시간 : 752ms
// 문제 링크 : https://www.acmicpc.net/problem/11659
