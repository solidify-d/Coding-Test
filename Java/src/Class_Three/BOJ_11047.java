package Class_Three;

import java.util.*;
import java.io.*;

public class BOJ_11047 { // 문제 : 동전 0
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄 입력: 동전 종류 수 N, 목표 금액 K
        // 람다 사용으로 인풋 스트링을 정수 배열에 담음
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // N개의 동전 단위 정보를 저장할 배열
        int[] coins = new int[inputs[0]];

        // 입력된 동전들은 항상 오름차순이므로, 배열의 뒤부터 채워서 내림차순 정렬 효과
        for (int i = inputs[0] - 1; i >= 0; i--) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int curr = inputs[1]; // 목표 금액 K
        int numCoins = 0;     // 사용한 동전 개수

        // 큰 동전부터 탐색하면서 현재 금액에서 최대한 많이 사용할 수 있는 동전 개수를 누적
        for (int i = 0; i < inputs[0]; i++) {
            if (curr >= coins[i]) {
                numCoins += curr / coins[i]; // 해당 동전을 몇 개 사용할 수 있는지 계산
                curr %= coins[i];            // 남은 금액 갱신
            }
        }

        // 전체 최소 동전 개수 출력
        System.out.println(numCoins);
    }
}

// 메모리 : 14456KB
// 시간 : 116ms
// 링크 : https://www.acmicpc.net/problem/11047
