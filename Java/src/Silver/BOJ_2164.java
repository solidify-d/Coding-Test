package Silver;

import java.util.*;
import java.io.*;

public class BOJ_2164 { // 문제 : 카드2
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int repeats = Integer.parseInt(br.readLine()); // 카드 개수 입력

        Queue<Integer> queue = new LinkedList<>(); // 큐 사용

        // 1부터 repeats까지 큐에 삽입
        for (int i = 1; i <= repeats; i++) {
            queue.add(i);
        }

        // 카드가 한 장 남을 때까지 반복
        while (queue.size() > 1) {
            queue.poll(); // 맨 위 카드 버림
            queue.add(queue.poll()); // 다음 카드를 맨 뒤로 옮김
        }

        // 마지막 남은 카드 출력
        System.out.println(queue.peek());
    }
}

// 메모리 : 45620KB
// 시간 : 164ms
// 문제 링크 : https://www.acmicpc.net/problem/2164