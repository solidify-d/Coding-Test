package Class_Three;

import java.io.*;
import java.util.*;

public class BOJ_11286 { // 문제 : 절댓값 힙
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int repeats = Integer.parseInt(br.readLine()); // 연산의 개수 입력

        // 우선순위 큐 정의: [절댓값, 원래 값] 형식의 int[]를 저장
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // 절댓값(0번째 요소) 기준으로 오름차순 정렬
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            // 절댓값이 같다면 원래 값(1번째 요소) 기준으로 오름차순 정렬
            return Integer.compare(a[1], b[1]);
        });

//        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] a, int[] b) {
//                // 절댓값(0번째 요소) 기준으로 오름차순 정렬
//                if (a[0] != b[0]) {
//                    return Integer.compare(a[0], b[0]);
//                }
//                // 절댓값이 같다면 원래 값(1번째 요소) 기준으로 오름차순 정렬
//                return Integer.compare(a[1], b[1]);
//            }
//        });

        for (int i = 0; i < repeats; i++) {
            int curr = Integer.parseInt(br.readLine()); // 입력값 curr

            if (curr == 0 && !pq.isEmpty()) {
                // 0이 입력되었고, 큐가 비어있지 않으면
                // 절댓값이 가장 작고, 같은 경우 원래 값이 더 작은 숫자 출력
                System.out.println(pq.poll()[1]);
            } else if (curr == 0 && pq.isEmpty()) {
                // 0이 입력되었고, 큐가 비어있으면 0 출력
                System.out.println(0);
            } else {
                // 0이 아닌 숫자 입력 시, [절댓값, 원래 값] 형태로 큐에 저장
                pq.add(new int[]{Math.abs(curr), curr});
            }
        }
    }
}

// 메모리 : 29700KB
// 시간 : 556ms
// 문제 링크 : https://www.acmicpc.net/problem/11286
