package Class_Two;

import java.io.*;
import java.util.*;

public class BOJ_1546 { // 문제 : 평균
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeats = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        // 문자열 배열 → double 배열로 변환
        double[] inputToDouble = Arrays.stream(inputs)
                .mapToDouble(Double::parseDouble)
                .toArray();

        // 최대값 구하기 (람다 사용)
        double max = Arrays.stream(inputToDouble)
                .max()
                .getAsDouble();

        // 새로운 점수로 환산 후 평균 계산
        double average = Arrays.stream(inputToDouble)
                .map(score -> (score / max) * 100.0)
                .average()
                .getAsDouble();

        System.out.println(average);
    }
}

// 메모리 : 17360KB
// 시간 : 160ms