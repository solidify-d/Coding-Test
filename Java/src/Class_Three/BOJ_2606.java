package Class_Three;

import java.util.*;
import java.io.*;

public class BOJ_2606 { // 문제 : 바이러스
    // 컴퓨터 수 (노드 개수)
    static int pcCount;

    // 네트워크 상에서 서로 연결되어 있는 쌍의 수 (간선 개수)
    static int pairs;

    // 인접 리스트 방식으로 그래프를 표현
    // graph[노드번호] -> 연결된 노드들의 리스트
    static List<Integer>[] graph;

    // 해당 노드를 방문했는지 여부를 저장하는 배열 (중복 탐색 방지용)
    static boolean[] visited;

    // 감염된 컴퓨터 수 (1번 컴퓨터를 제외하고 카운트)
    static int infectedCount = 0;

    // 깊이 우선 탐색(DFS) 메서드
    public static void dfs(int node) {
        // 현재 노드를 방문 처리
        visited[node] = true;

        // 현재 노드와 연결된 모든 이웃 노드를 순회
        for (int next : graph[node]) {
            // 아직 방문하지 않은 노드라면
            if (!visited[next]) {
                // 감염된 컴퓨터 수 증가 (1번 컴퓨터를 제외하고 처음 방문할 때마다 카운트 증가)
                infectedCount++;

                // 재귀적으로 DFS 호출 (다음 노드 방문)
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 컴퓨터 수 입력 (노드 수)
        pcCount = Integer.parseInt(br.readLine());

        // 연결 쌍 수 입력 (간선 수)
        pairs = Integer.parseInt(br.readLine());

        // 인접 리스트 배열 생성 (1번부터 사용하므로 pcCount + 1 크기로 생성)
        graph = new ArrayList[pcCount + 1];

        // 각 리스트 요소를 실제로 ArrayList로 초기화
        // 이 부분이 중요하다. 이 초기화가 없으면 NullPointerException 발생
        for (int i = 1; i <= pcCount; i++) {
            graph[i] = new ArrayList<>();
        }

        // 연결된 컴퓨터 쌍 입력받아 양방향 연결 (무방향 그래프)
        for (int i = 0; i < pairs; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // from : 시작 노드 번호
            // to : 도착 노드 번호
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 양방향 연결이므로 서로의 리스트에 상대 노드를 추가
            graph[from].add(to);
            graph[to].add(from);
        }

        // 방문 여부 배열 초기화 (false로 초기화됨)
        visited = new boolean[pcCount + 1];

        // DFS 탐색 시작 (1번 컴퓨터에서 바이러스 시작)
        dfs(1);

        // 결과 출력 : 감염된 컴퓨터 수 (1번 컴퓨터를 제외하고 감염된 컴퓨터 수)
        System.out.println(infectedCount);
    }
}
