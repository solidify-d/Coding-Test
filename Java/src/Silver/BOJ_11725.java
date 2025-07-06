package Silver;

import java.io.*;
import java.util.*;

public class BOJ_11725 {
    // 트리의 부모 찾기 문제 (백준 11725)

    // 인접 리스트로 트리 구조를 표현하기 위한 변수
    static List<List<Integer>> adjList = new ArrayList<>();

    // 각 노드의 부모 번호를 저장할 배열
    static int[] parentTracker;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 노드 개수 입력

        parentTracker = new int[n + 1];  // 부모 정보를 저장할 배열 생성 (1번 노드부터 사용)

        // 인접 리스트 초기화: 노드 번호에 맞춰 리스트를 생성
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        // 간선 정보 입력: 트리는 N개의 노드에 대해 N-1개의 간선으로 구성
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            // 무방향 간선이므로 양쪽 모두에 추가
            adjList.get(first).add(second);
            adjList.get(second).add(first);
        }

        // DFS를 통해 각 노드의 부모 찾기 시작
        // 루트 노드는 1번, 루트의 부모는 0으로 설정 (없음을 의미)
        dfs(1, 0);

        // 결과 출력: 2번 노드부터 부모 노드 번호를 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parentTracker[i]).append("\n");
        }
        System.out.print(sb);
    }

    /**
     * DFS 메서드
     *
     * @param curr 현재 방문한 노드 번호
     * @param par curr 노드의 부모 노드 번호
     */

    static void dfs(int curr, int par) {
        // 현재 노드의 부모를 parent 배열에 기록
        parentTracker[curr] = par;

        // curr 노드와 연결된 모든 노드(next)를 탐색
        for (int next : adjList.get(curr)) {
            // 부모 노드로 다시 가지 않도록 체크
            if (next != par) {
                // 다음 노드를 방문하면서 현재 노드를 부모로 넘겨줌
                dfs(next, curr);
            }
        }
    }
}

// 메모리 : 65788KB
// 시간 : 776ms
// 문제 링크 : https://www.acmicpc.net/problem/11725