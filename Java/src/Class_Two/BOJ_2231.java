package Class_Two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2231 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받은 문자열을 정수형으로 변환
        int num = Integer.parseInt(br.readLine());

        // 가능한 모든 생성자 후보를 0부터 (num - 1)까지 순회
        for (int i = 0; i < num; i++) {
            int sum = i;      // 분해합의 초기값은 자기 자신(i)
            int temp = i;     // 자리수를 나눌 임시 변수

            // 각 자리수의 숫자를 모두 더함
            while (temp != 0) {
                sum += temp % 10;  // 1의 자리 숫자를 sum에 추가 ex. 216 % 10 = 6
                temp /= 10;        // 다음 자리수를 위해 10으로 나눔
            }

            // 분해합이 입력값(num)과 같다면, i는 생성자
            if (sum == num) {
                System.out.println(i);  // 가장 작은 생성자를 출력
                return;                 // 프로그램 종료 (처음 찾은 생성자가 가장 작은 값이므로 더 이상 탐색할 필요 없음)
            }
        }

        // 생성자가 존재하지 않을 경우 0 출력
        System.out.println(0);
    }
}

// 메모리 : 14320KB
// 시간 : 144ms