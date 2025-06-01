package Class_Two;

import java.io.*;
import java.util.*;

public class BOJ_2609 { // 백준 2609번: 최대공약수와 최소공배수
    // ✅ 유클리드 호제법을 이용한 최대공약수(GCD) 계산
    public static int gcd(int a, int b) {
        while (b != 0) {            // b가 0이 될 때까지 반복
            int temp = a % b;       // a를 b로 나눈 나머지를 temp에 저장
            a = b;                  // a는 이전 b로 대체
            b = temp;               // b는 나머지로 대체
        }
        return a;                   // b가 0이 되면 a가 최대공약수
    }

    // ✅ 최소공배수(LCM) 계산: 두 수의 곱을 최대공약수로 나눈 값
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) throws IOException {
        // 표준 입력으로부터 한 줄을 읽기 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받은 문자열을 공백 기준으로 나눈 후 정수 배열로 변환
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray(); // 예: 입력이 "24 18"이면 [24, 18]로 변환됨

        // 출력 결과를 효율적으로 모으기 위한 StringBuilder 사용
        StringBuilder sb = new StringBuilder();

        // 최대공약수와 최소공배수를 계산하여 결과에 추가
        sb.append(gcd(numbers[0], numbers[1])) // 첫 줄: 최대공약수
                .append("\n")
                .append(lcm(numbers[0], numbers[1])); // 둘째 줄: 최소공배수

        // 결과 출력
        System.out.print(sb);
    }
}

// 메모리 사용량 : 14536KB
// 실행 시간     : 132ms