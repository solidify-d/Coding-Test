package Class_Three;

import java.io.*;
import java.util.*;

public class BOJ_1697 { // 문제 : 숨바꼭질
    static final int NODE_CNT = 100001; // 가능한 위치 범위 (0~100000)
    static boolean[] visited = new boolean[NODE_CNT]; // 각 위치의 방문 여부 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startPos = Integer.parseInt(st.nextToken()); // 시작 위치
        int targetPos = Integer.parseInt(st.nextToken()); // 목표 위치

        bfs(startPos, targetPos); // BFS 탐색 시작
    }

    static void bfs(int startPos, int targetPos) {
        Queue<int[]> queue = new LinkedList<>(); // 큐 선언: 각 원소는 [현재 위치, 시간]
        queue.add(new int[]{startPos, 0}); // 시작 위치와 시간(0초) 삽입
        visited[startPos] = true; // 시작 위치 방문 처리

        while (!queue.isEmpty()) { // 큐가 빌 때까지 반복
            int[] currNode = queue.poll(); // 현재 노드 꺼내기

            int currPos = currNode[0]; // 현재 위치
            int currTime = currNode[1]; // 현재까지 걸린 시간

            if (currPos == targetPos) { // 목표 위치에 도달한 경우
                System.out.println(currTime); // 최소 시간 출력
                return; // 종료
            }

            int[] nextPositions = {currPos + 1, currPos - 1, currPos * 2}; // 이동 가능한 다음 위치들

            for (int nextPos : nextPositions) { // 다음 위치들에 대해 반복
                if (nextPos >= 0 && nextPos < NODE_CNT && !visited[nextPos]) { // 유효 범위 내이며 방문하지 않은 경우
                    visited[nextPos] = true; // 방문 처리
                    queue.add(new int[]{nextPos, currTime + 1}); // 다음 위치와 시간 증가 후 큐에 삽입
                }
            }
        }
    }
}

// 메모리 : 23276KB
// 시간 : 148ms
// 문제 링크 : https://www.acmicpc.net/problem/1697