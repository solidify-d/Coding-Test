package Bronze;

import java.util.*;
import java.io.*;

public class BOJ_1302 { // 문제: 베스트셀러 (가장 많이 팔린 책의 제목을 출력)
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int repeats = Integer.parseInt(br.readLine()); // 입력 받을 책 제목의 개수
        Map<String, Integer> salesRecords = new HashMap<>(); // 책 제목별 판매 횟수를 저장할 HashMap

        // 각 책 제목을 입력받아 판매 횟수를 기록
        for (int i = 0; i < repeats; i++) {
            String title = br.readLine(); // 책 제목 입력
            salesRecords.put(title, salesRecords.getOrDefault(title, 0) + 1); // 제목이 이미 있으면 +1, 없으면 1로 초기화
        }

        int maxSales = 0; // 가장 많이 팔린 책의 판매 횟수를 저장할 변수

        // 판매 기록 중 가장 높은 판매 횟수를 구함
        for (String title : salesRecords.keySet()) {
            int count = salesRecords.get(title); // 해당 제목의 판매 횟수
            if (count > maxSales) {
                maxSales = count; // 최댓값 갱신
            }
        }

        List<String> bestSellers = new ArrayList<>(); // 최다 판매 횟수를 기록한 책 제목들을 저장

        // 최대 판매 횟수와 일치하는 책 제목을 리스트에 추가
        for (String title : salesRecords.keySet()) {
            if (salesRecords.get(title) == maxSales) {
                bestSellers.add(title);
            }
        }

        // 사전 순으로 정렬하여 가장 앞선 제목을 선택
        Collections.sort(bestSellers);
        System.out.println(bestSellers.get(0)); // 최종 출력: 사전순으로 가장 앞선 베스트셀러 제목
    }
}
