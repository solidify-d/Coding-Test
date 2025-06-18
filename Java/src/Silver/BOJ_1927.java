package Silver;

import java.util.*;
import java.io.*;

public class BOJ_1927 { // 문제 : 최소힙
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalCount = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < totalCount; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0){
                if(queue.isEmpty()) sb.append(0).append("\n");
                else sb.append(queue.poll()).append("\n");
            } else {
                queue.add(input);
            }
        }

        System.out.println(sb);
    }
}

// 메모리 : 26560KB
// 시간 : 276ms
// 링크 : https://www.acmicpc.net/problem/1927