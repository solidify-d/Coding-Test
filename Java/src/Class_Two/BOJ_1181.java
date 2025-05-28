package Class_Two;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받을 단어 수
        int repeats = Integer.parseInt(br.readLine());

        // 단어들을 저장할 배열
        String[] words = new String[repeats];
        Arrays.fill(words, ""); // 배열을 빈 문자열로 초기화

        // 입력받은 단어 저장
        for(int i = 0; i < repeats; i++){
            words[i] += br.readLine(); // 입력받은 문자열을 배열에 저장
        }

        // 먼저 사전순 정렬 수행 (길이가 같을 경우 우선순위를 미리 확보하기 위해)
        Arrays.sort(words);

        // 그 다음, 길이 기준으로 정렬 (길이가 짧은 순으로)
        Arrays.sort(words, Comparator.comparingInt((s) -> s.length()));

        // 결과 출력을 위한 StringBuilder 초기화
        StringBuilder sb = new StringBuilder();

        // 중복 제거를 위한 이전 단어 저장 변수
        String prev = "";

        // 정렬된 단어 배열을 순회하며 중복 없이 출력
        for (String word : words) {
            if (prev.equals(word)) {
                continue; // 이전 단어와 같으면 출력하지 않음 (이미 Arrays.sort를 통해 정렬되어 있음으로 만약 중복된 단어가 있다면 prev.equals(curr) 상황이 무조건 발생)
            }
            sb.append(word).append("\n"); // 단어를 StringBuilder에 더함
            prev = word; // 현재 단어를 이전 단어로 갱신
        }

        // 최종 결과 출력
        System.out.println(sb); // 한번의 호출로 모든 단어 출력
    }
}

// 메모리 : 27772KB
// 시간 : 360ms

// 문제 링크 : https://www.acmicpc.net/problem/1181