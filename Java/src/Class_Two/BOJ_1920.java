package Class_Two;

import java.util.*;
import java.io.*;

public class BOJ_1920 { // 문제 : 수 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int firstNum = Integer.parseInt(br.readLine());
        int[] firstNums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int secondNum = Integer.parseInt(br.readLine());
        int[] secondNums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < firstNum; i++) {
            hs.add(firstNums[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < secondNum; i++) {
            if (hs.contains(secondNums[i])) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb);
    }
}

// 메모리 : 51960KB
// 시간 : 552ms
// 문제 링크 : https://www.acmicpc.net/problem/1920