package Class_Three;

import java.util.*;
import java.io.*;

public class BOJ_1764 { // 문제 : 듣보잡
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 입력을 위한 BufferedReader 사용

        // TreeSet 사용: 자동 정렬을 지원하는 Set (사전순 정렬 목적)
        TreeSet<String> setN = new TreeSet<>(); // 듣도 못한 사람 목록
        Set<String> setM = new HashSet<>(); // 보도 못한 사람 목록

        // 첫 줄 입력: N(듣도 못한 사람 수), M(보도 못한 사람 수)
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 듣도 못한 사람 이름 입력 → setN에 저장
        for (int i = 0; i < inputs[0]; i++) {
            setN.add(br.readLine());
        }

        // 보도 못한 사람 이름 입력 → setM에 저장
        for (int i = 0; i < inputs[1]; i++) {
            setM.add(br.readLine());
        }

        int count = 0; // 듣보잡 인원 수를 셀 변수
        StringBuilder sb = new StringBuilder(); // 결과 출력을 위한 StringBuilder (출력 최적화)

        // setN 순회 → setM에도 포함되어 있다면 듣보잡
        for(String curr : setN){
            if(setM.contains(curr)){
                sb.append(curr).append("\n");
                count++; // 카운트 증가
            }
        }

        // 듣보잡 수 출력
        System.out.println(count);
        // 듣보잡 명단 출력 (TreeSet이기에 따로 정렬 처리를 하지 않아도 사전순)
        System.out.println(sb);
    }
}