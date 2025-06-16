package Class_Three;

import java.util.*;
import java.io.*;

public class BOJ_11723 { // 문제 : 집합
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // check 명령어에 대한 출력 결과를 저장할 StringBuilder (출력 최적화)
        StringBuilder sb = new StringBuilder();

        // 집합 S를 표현하기 위해 HashSet 사용 (중복 없음, 삽입/삭제/탐색 평균 O(1))
        Set<Integer> set = new HashSet<>();

        // 명령어 개수 입력
        int repeats = Integer.parseInt(br.readLine());

        // 명령어 개수만큼 반복 처리
        for (int i = 0; i < repeats; i++) {
            // 한 줄 입력을 공백 기준으로 분리
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken(); // 명령어 종류 (add, remove, check, ...)

            switch (command) {

                // "add x": 집합 S에 x를 추가 (이미 있으면 무시됨)
                case "add":
                    set.add(Integer.parseInt(st.nextToken()));
                    break;

                // "remove x": 집합 S에서 x를 제거 (없으면 무시됨)
                case "remove":
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;

                // "check x": x가 집합 S에 있으면 1, 없으면 0을 StringBuilder에 추가
                case "check":
                    sb.append(set.contains(Integer.parseInt(st.nextToken())) ? "1\n" : "0\n");
                    break;

                // "toggle x": x가 집합에 있으면 제거, 없으면 추가 (상태를 반전시킴)
                case "toggle":
                    int num = Integer.parseInt(st.nextToken());
                    if (set.contains(num)) set.remove(num);
                    else set.add(num);
                    break;

                // "all": 집합 S를 {1, 2, ..., 20}으로 설정 (전체 채우기)
                case "all":
                    set.clear(); // 기존 집합 초기화 후
                    for (int j = 1; j <= 20; j++) set.add(j); // 1부터 20까지 추가
                    break;

                // "empty": 집합 S를 공집합으로 설정 (모든 원소 제거)
                case "empty":
                    set.clear();
                    break;
            }
        }

        // check 명령 결과를 한 번에 출력 (출력 최적화)
        System.out.print(sb);
    }
}
