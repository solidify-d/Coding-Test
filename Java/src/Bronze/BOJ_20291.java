package Bronze;

import java.io.*;
import java.util.*;

public class BOJ_20291 { // 문제 : 파일 정리
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int repeats = Integer.parseInt(br.readLine());

        Map<String, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < repeats; i++) {
            String[] temp = br.readLine().split("\\.");
            treeMap.put(temp[1], treeMap.getOrDefault(temp[1], 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (String curr : treeMap.keySet()){
            sb.append(curr).append(" ").append(treeMap.get(curr)).append("\n");
        }

        System.out.println(sb);
    }
}

// 메모리 : 65068KB
// 시간 : 728ms