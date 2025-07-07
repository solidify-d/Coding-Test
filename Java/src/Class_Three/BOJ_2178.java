package Class_Three;

import java.util.*;
import java.io.*;

public class BOJ_2178 { // 문제 : 미로 탐색
    static boolean[][] visited; // 각 칸의 방문 여부를 저장
    static int[][] map;         // 미로 정보를 저장하는 2차원 배열(1: 길, 0: 벽)
    static int N;               // 세로 크기(행 개수)
    static int M;               // 가로 크기(열 개수)

    // 상하좌우 이동을 위한 델타 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        // 표준 입력을 빠르게 읽기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 공백 기준으로 토큰 분리
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 초기화
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 미로와 방문 배열 크기 지정
        map = new int[N][M];
        visited = new boolean[N][M];

        // 미로 정보 입력
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray(); // 한 행을 문자 배열로 변환
            for (int j = 0; j < M; j++) {
                map[i][j] = chars[j] - '0'; // 문자 '0' 또는 '1' → 정수 0 또는 1
            }
        }

        // (0,0)에서 BFS 실행 후 결과 출력
        System.out.println(bfs(0, 0));
    }

    static public int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();         // [x, y, 거리]를 담는 큐
        queue.add(new int[]{x, y, 1});                   // 시작 지점 (0,0), 시작 거리 1
        visited[x][y] = true;                            // 시작 지점 방문 처리

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();                   // 현재 좌표 & 거리 꺼내기
            int currX = curr[0];
            int currY = curr[1];
            int count = curr[2];

            // 도착 지점(맨 오른쪽 아래)에 도달하면 최단 거리 반환
            if (currX == N - 1 && currY == M - 1) {
                return count;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                // 좌표가 미로 범위 안에 있고, 아직 방문하지 않았으며, 길(=1)인 경우
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    if (!visited[nextX][nextY] && map[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;             // 방문 처리
                        queue.add(new int[]{nextX, nextY, count + 1}); // 거리 +1 후 큐에 삽입
                    }
                }
            }
        }

        return -1; // 도달 불가능한 경우(문제 조건상 발생하지 않음)
    }
}

// 메모리 : 14696KB
// 시간 : 120ms
// 문제 링크 : https://www.acmicpc.net/problem/2178