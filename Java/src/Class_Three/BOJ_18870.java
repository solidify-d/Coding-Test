package Class_Three;

import java.io.*;
import java.util.*;

public class BOJ_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 좌표 개수 입력

        // 공백 기준으로 나눈 문자열 배열을 int[] 배열로 변환 (람다 사용)
        int[] origin = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 원본 배열을 복사하여 정렬용으로 사용
        int[] sorted = origin.clone();

        // 오름차순 정렬 (좌표 압축을 위해 정렬이 필요함)
        Arrays.sort(sorted);

        // 좌표 → 압축값을 저장할 Map (중복된 값은 무시)
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : sorted) {
            // 처음 등장하는 좌표만 압축값을 할당
            if (!map.containsKey(num)) {
                map.put(num, count++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : origin) {
            sb.append(map.get(num)).append(' ');
        }

        // 결과 출력
        System.out.println(sb);
    }
}

// 메모리 : 281808KB
// 시간 : 1788ms