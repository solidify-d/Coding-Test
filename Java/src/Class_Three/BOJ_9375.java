package Class_Three;

import java.util.*;
import java.io.*;

public class BOJ_9375 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int repeats = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < repeats; i++) {
            int n = Integer.parseInt(br.readLine()); // 의상의 수

            Map<String, Integer> clothesMap = new HashMap<>();

            for(int j = 0; j < n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String item = st.nextToken();  // 의상 이름 (사실 사용 안 함)
                String category = st.nextToken();  // 의상 종류

                // 의상 종류별 개수 누적
                clothesMap.put(category, clothesMap.getOrDefault(category, 0) + 1);
            }

            int result = 1;

            // 각 의상 종류별로 (개수 + 1) 곱하기 (각 종류마다 입지 않는 선택지도 있기 때문)
            for(int count : clothesMap.values()){
                result *= (count + 1);
            }

            // 알몸 제외 (-1)
            System.out.println(result - 1);
        }
    }
}

// 메모리 : 14316KB
// 시간 : 136ms
// 문제 링크 : https://www.acmicpc.net/problem/9375