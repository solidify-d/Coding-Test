package Class_Three;

import java.io.*;
import java.util.*;


public class BOJ_17219 { // 문제 : 비밀번호 찾기
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 처리하기 위한 BufferedReader 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄에서 입력된 두 수 N(저장된 사이트 수), M(찾으려는 사이트 수)을 정수 배열로 변환
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 사이트 주소(key)와 비밀번호(value)를 저장할 HashMap 선언
        HashMap<String, String> websitePasswords = new HashMap<>();

        // N개의 사이트 주소와 비밀번호를 입력받아 해시맵에 저장
        for (int i = 0; i < inputs[0]; i++) {
            // 공백으로 나뉘는 두 개의 입력(사이트 주소, 비밀번호)
            StringTokenizer st = new StringTokenizer(br.readLine());
            websitePasswords.put(st.nextToken(), st.nextToken()); // 맵에 저장
        }

        // 결과 출력을 위한 StringBuilder (출력 최적화를 위함)
        StringBuilder sb = new StringBuilder();

        // M개의 질의에 대해 사이트 주소를 입력받고, 해당 비밀번호를 맵에서 찾아 출력 버퍼에 저장
        for (int i = 0; i < inputs[1]; i++) {
            String querySite = br.readLine();                 // 찾으려는 사이트 주소
            sb.append(websitePasswords.get(querySite))        // 해시맵에서 비밀번호 조회
                    .append("\n");                            // 줄바꿈 추가
        }

        // 전체 결과 한 번에 출력
        System.out.println(sb);
    }
}

// 메모리 : 56424KB
// 시간 : 548ms
// 링크 : https://www.acmicpc.net/problem/17219