import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 0부터 9까지의 등장 횟수를 저장할 배열을 선언한다.
        int[] count = new int[10];

        // 세 개의 자연수 A, B, C를 입력받는다.
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        // A * B * C의 결과값을 계산한다.
        int mult = A * B * C;

        // 곱셈 결과의 각 자릿수를 분해하여 숫자별로 몇 번 등장했는지를 count 배열에 기록한다.
        while (mult > 0) {
            int digit = mult % 10; // 가장 오른쪽 자릿수 추출
            count[digit] += 1;     // 해당 숫자 인덱스의 카운트를 1 증가
            mult /= 10;            // 이미 처리한 자릿수를 제거 (10으로 나눈 후 저장)
        }

        // 숫자 0부터 9까지 각 숫자가 몇 번씩 나왔는지 순서대로 출력한다.
        for (int i = 0; i < 10; i++) {
            System.out.println(count[i]);
        }
    }
}

// 메모리 : 14104KB
// 시간 : 100ms