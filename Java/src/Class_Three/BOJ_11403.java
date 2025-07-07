package Class_Three;

import java.io.*;
import java.util.*;

public class BOJ_11403 { // 문제 : 경로 찾기
    // 방향 그래프를 인접 리스트로 표현
    static List<List<Integer>> graph;
    static int[][] map; // 입력된 인접 행렬
    static int[][] ans; // 정답 행렬 (경로 존재 여부 저장)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine()); // 정점 개수
        graph = new ArrayList<>();
        map = new int[size][size];
        ans = new int[size][size];

        // 인접 행렬 입력 받기
        for (int i = 0; i < size; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        // 인접 리스트 초기화
        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }

        // 방향 그래프 구성: i → j 간선만 추가
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        // 각 정점에서 BFS 수행하여 도달 가능한 정점 기록
        for (int i = 0; i < size; i++) {
            bfs(i, size);
        }

        // 출력 포맷 구성
        StringBuilder sb = new StringBuilder();
        for (int[] rows : ans) {
            for (int coord : rows) {
                sb.append(coord).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    // 시작 정점에서 도달 가능한 모든 정점 탐색 (경로 존재 여부 체크)
    public static void bfs(int start, int size) {
        boolean[] visited = new boolean[size]; // 매 시작점마다 방문 배열 초기화
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;        // 해당 정점 방문 표시
                    ans[start][next] = 1;        // 경로 존재 표시
                    queue.add(next);             // 계속 탐색
                }
            }
        }
    }
}

// 메모리 : 16712KB
// 시간 : 168ms
// 문제 링크 : https://www.acmicpc.net/problem/11403