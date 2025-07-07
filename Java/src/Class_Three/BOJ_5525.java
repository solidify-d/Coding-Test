package Class_Three;

import java.util.*;
import java.io.*;

public class BOJ_5525 { // 문제 : IOIOI
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // PN에서의 N (찾고자 하는 'IOI' 반복 수)
        int M = Integer.parseInt(br.readLine()); // 입력 문자열 S의 길이
        int count = 0; // 조건에 맞는 PN 패턴의 개수
        Queue<Character> queue = new LinkedList<>(); // (선택적) 문자 흐름 추적용 큐
        char[] S = br.readLine().toCharArray(); // 문자열 S를 문자 배열로 변환

        char prev = S[0]; // 현재 위치 기준 바로 이전 문자 저장용
        queue.add(prev); // 첫 문자를 큐에 추가
        int sequence = 0; // 연속된 'IOI' 패턴의 수

        for (int i = 1; i < M; i++) {
            char temp = S[i]; // 현재 문자
            queue.add(temp); // 큐에 현재 문자 추가

            // 'IOI' 패턴 탐색 시작
            if (prev == 'I' && temp == 'O') {
                // 다음 문자가 'I'라면 'IOI' 패턴 완성 가능
                if (i + 1 < M && S[i + 1] == 'I') {
                    sequence++; // 연속 IOI 패턴 수 증가

                    if (sequence == N) {
                        count++;     // N개의 IOI → 하나의 PN 완성
                        sequence--;  // 중첩 탐지를 위해 마지막 IOI 1개 유지
                    }

                    i++;           // 다음 'I'까지 소비했으므로 i를 한 칸 더 이동
                    temp = 'I';    // S[i+1]을 prev로 넘기기 위한 temp 갱신
                } else {
                    sequence = 0;  // 'IO' 다음이 'I'가 아니라면 패턴 깨짐 → 초기화
                }
            } else {
                sequence = 0;      // 'IO' 패턴 자체가 아니면 초기화
            }

            prev = temp; // 다음 루프를 위한 이전 문자 설정
        }

        System.out.println(count); // 결과 출력
    }
}

// 메모리 : 45672KB
// 시간 : 276ms
// 문제 링크 : https://www.acmicpc.net/problem/5525