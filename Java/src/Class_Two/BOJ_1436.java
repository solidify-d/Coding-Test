package Class_Two;

import java.io.*;

public class BOJ_1436 { // 문제: 영화감독 숌
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 효율적으로 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N번째로 등장하는 "666"이 포함된 수를 입력으로 받음
        int repeats = Integer.parseInt(br.readLine());

        // 조건을 만족하는 수의 개수를 셀 변수
        int count = 0;

        // 666부터 시작하여 하나씩 증가시키며 검사
        int curr = 666;

        // 무한 루프를 돌며 조건을 만족하는 수를 찾음
        while (true) {
            // 현재 수에 "666"이라는 숫자가 포함되어 있는지 검사
            if (Integer.toString(curr).contains("666")) {
                count++; // 포함되어 있으면 카운트를 증가시킴

                // 입ㅁ력받은 N번째 조건에 도달했으면 출력 후 종료
                if (count == repeats) {
                    System.out.print(curr); // 결과 출력 (줄바꿈 없음)
                    return; // 프로그램 종료
                }
            }
            // 다음 수로 증가
            curr++;
        }
    }
}

// 메모리 사용량: 84268KB
// 실행 시간: 248ms