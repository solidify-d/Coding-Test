package Class_Three;

import java.io.*;

public class BOJ_21736 { // 문제 : 헌내기는 친구가 필요해
    // 방향 벡터: 상하좌우 (dx는 행, dy는 열 이동을 나타냄)
    static int[] dx = {-1, 1, 0, 0}; // 위, 아래
    static int[] dy = {0, 0, -1, 1}; // 왼쪽, 오른쪽

    static char[][] arr;           // 캠퍼스 지도를 담을 2차원 문자 배열
    static boolean[][] visited;    // 방문 여부를 체크할 배열
    static int count = 0;          // 만난 친구(P)의 수
    static int rows, columns;      // 행과 열의 크기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 캠퍼스 크기 입력 받기
        String[] size = br.readLine().split(" ");
        rows = Integer.parseInt(size[0]);    // 행 (세로)
        columns = Integer.parseInt(size[1]); // 열 (가로)

        arr = new char[rows][columns];           // 캠퍼스 맵 초기화
        visited = new boolean[rows][columns];    // 방문 여부 배열 초기화

        int initX = 0, initY = 0; // 'I'의 시작 좌표 (도연이의 위치)

        // 캠퍼스 지도 입력 받기 및 시작점 찾기
        for (int i = 0; i < rows; i++) {
            String line = br.readLine(); // 한 줄 입력
            for (int j = 0; j < columns; j++) {
                arr[i][j] = line.charAt(j); // 문자 하나씩 저장
                if (arr[i][j] == 'I') {     // 시작점이면 좌표 저장
                    initX = i;
                    initY = j;
                }
            }
        }

        // DFS 탐색 시작
        dfs(initX, initY);

        // 친구를 한 명도 못 만난 경우
        if (count == 0) System.out.println("TT");
        else System.out.println(count); // 만난 친구 수 출력
    }

    // DFS 재귀 함수
    static void dfs(int x, int y) {
        // 범위를 벗어났거나
        if (x < 0 || y < 0 || x >= rows || y >= columns) return;

        // 이미 방문한 곳이거나
        if (visited[x][y]) return;

        // 벽('X')인 경우 탐색 중단
        if (arr[x][y] == 'X') return;

        // 현재 위치 방문 처리
        visited[x][y] = true;

        // 친구(P)를 만난 경우 count 증가
        if (arr[x][y] == 'P') count++;

        // 상하좌우 인접 칸으로 DFS 진행
        for (int i = 0; i < 4; i++) {
            dfs(x + dx[i], y + dy[i]);
        }
    }
}

// 메모리 : 43924KB
// 시간 : 276ms
// 문제 링크 : https://www.acmicpc.net/problem/21736
