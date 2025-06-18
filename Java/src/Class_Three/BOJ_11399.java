package Class_Three;

import java.io.*;
import java.util.*;

// 백준 11399번 문제 : ATM
public class BOJ_11399 {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 : 사람 수 (입력 받기)
        int num = Integer.parseInt(br.readLine());

        // 두 번째 줄 : 각 사람이 걸리는 시간 배열 입력 받기
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // PriorityQueue(우선순위 큐)를 이용하여 자동 오름차순 정렬
        // 즉, 시간이 짧은 사람부터 먼저 처리되도록 하기 위함
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 입력된 각 사람의 인출 시간을 큐에 삽입
        for (int i = 0; i < num; i++) {
            pq.add(inputs[i]);
        }

        // 현재까지 누적된 시간
        int timeTaken = 0;

        // 전체 대기 시간의 합을 저장할 변수
        int totalTimeTaken = 0;

        // 우선순위 큐에서 하나씩 꺼내면서 누적 시간 계산
        // -> 짧은 시간부터 꺼내기 때문에 대기 시간의 총합이 최소화됨
        for (int i = 0; i < num; i++) {
            // 현재 사람의 대기 시간 추가 (이전 사람들의 시간 누적)
            timeTaken += pq.poll();

            // 전체 대기 시간에 현재 누적 시간을 더함 (i번째 사람의 대기 시간을 누적)
            totalTimeTaken += timeTaken;
        }

        // 최종적으로 계산된 최소 대기 시간의 총합 출력
        System.out.println(totalTimeTaken);
    }
}

// 메모리 : 14648KB
// 시간 : 116ms
// 링크 : https://www.acmicpc.net/problem/11399