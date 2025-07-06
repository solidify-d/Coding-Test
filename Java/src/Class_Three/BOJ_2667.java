package Class_Three;

import java.util.*;
import java.io.*;

public class BOJ_2667 { // 문제 : 단지번호붙이기
    // 상하좌우 이동을 위한 배열
    static int[] dx = {-1, 1, 0, 0}; // 위, 아래
    static int[] dy = {0, 0, -1, 1}; // 왼쪽, 오른쪽

    static boolean[][] visited; // 방문 여부 확인 배열
    static int size; // 지도의 크기
    static int[][] map; // 지도 정보 (1: 집 있음, 0: 집 없음)
    static HashMap<Integer, Integer> sizeMap = new HashMap<>(); // 단지 번호별 집의 개수 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine()); // 지도 크기 입력

        map = new int[size][size]; // 지도 배열 초기화
        visited = new boolean[size][size]; // 방문 배열 초기화

        // 지도 정보 입력
        for (int i = 0; i < size; i++) {
            char[] chars = br.readLine().toCharArray(); // 한 줄 문자열을 문자 배열로 변환
            for (int j = 0; j < size; j++) {
                map[i][j] = chars[j] - '0';
                // '0'은 48번 코드이므로, 그 값을 기준점으로 삼아 빼면 정수값 0~9를 얻을 수 있다.
            }
        }

        int groupId = -1; // 단지 번호 초기값 설정 (-1부터 시작하여 첫 단지는 0부터)

        // 지도 전체를 순회하며 아직 방문하지 않은 집(1)이 있으면 DFS 수행
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j]) {
                    groupId++; // 새로운 단지 번호 할당
                    dfs(i, j, groupId); // 해당 좌표에서 DFS 탐색 시작
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(sizeMap.size()).append("\n"); // 단지 개수 출력

        List<Integer> sizeMapToList = new ArrayList<>(sizeMap.values()); // 단지별 집 수를 리스트로 변환
        Collections.sort(sizeMapToList);  // 단지 크기 오름차순 정렬

        // 정렬된 단지별 집 수 출력
        for (int curr : sizeMapToList) {
            sb.append(curr).append("\n");
        }

        System.out.println(sb); // 최종 출력
    }

    // DFS 메서드: 현재 좌표(x,y)와 단지 번호(groupId)를 인자로 받음
    static public void dfs(int x, int y, int groupId) {
        // 좌표가 지도 범위를 벗어나면 종료
        if (x < 0 || y < 0 || x >= size || y >= size) return;
        // 이미 방문한 곳이면 종료
        if (visited[x][y]) return;
        // 집이 없는 곳(0)이면 종료
        if (map[x][y] == 0) return;

        visited[x][y] = true; // 현재 좌표 방문 처리

        if (map[x][y] == 1) {
            incrementSize(groupId); // 단지 크기 1 증가
        }

        // 상하좌우 방향으로 DFS 재귀 호출
        for (int i = 0; i < 4; i++) {
            dfs(x + dx[i], y + dy[i], groupId);
        }
    }

    // 단지 번호별 집 수를 1씩 증가시키는 메서드
    static public void incrementSize(int groupId) {
        sizeMap.put(groupId, sizeMap.getOrDefault(groupId, 0) + 1);
    }
}

// 메모리 : 14216KB
// 시간 : 108ms
// 문제 링크 : https://www.acmicpc.net/problem/2667