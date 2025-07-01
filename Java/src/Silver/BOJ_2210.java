package Silver;

import java.io.*;
import java.util.*;

public class BOJ_2210 { // 문제 : 숫자판 점프
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Set<String> mySet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[5][5];

        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                helper("", i, j, arr);
            }
        }

        System.out.println(mySet.size());
    }

    static void helper(String returnVal, int nx, int ny, int[][] arr) {
        if (nx < 0 || ny < 0 || nx > 4 || ny > 4) return;
        if (returnVal.length() == 6) {
            mySet.add(returnVal);
            return;
        }
        returnVal += arr[nx][ny];
        for (int i = 0; i < 4; i++) {
            helper(returnVal, nx + dx[i], ny + dy[i], arr);
        }
    }
}

// 메모리 : 19908KB
// 시간 : 172ms
// 문제 링크 : https://www.acmicpc.net/problem/2210