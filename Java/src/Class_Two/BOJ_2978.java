package Class_Two;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]); // 카드의 개수
        int M = Integer.parseInt(inputs[1]); // 카드에 쓰여 있는 수
        String[] cards = br.readLine().split(" ");
        int returnVal = 0;
        br.close();

        // 모든 경우의 수를 확인 할 수 있게금 3중 For문 사용
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int curr = Integer.parseInt(cards[i]) +
                            Integer.parseInt(cards[j]) +
                            Integer.parseInt(cards[k]);

                    // System.out.println(i + " " + j + " " + k + " // " + cards[i] + " + " + cards[j] + " + " + cards[k] + " = " + curr); // 로그 확인용 프린트

                    // curr이 M보다 작거나 같고, curr이 현재 returnVal보다 클 경우:
                    // #1. 만약 M 과 curr이 일치하면 curr 프린트 후 Main 함수 종료
                    // #2. 만약 M과 curr이 일치하지 않으면 returnVal를 curr로 업데이트
                    if (curr <= M && curr > returnVal) {
                        if (M == curr){ // Section A
                            System.out.println(curr);
                            return;
                        }
                        returnVal = curr;
                    }
                }
            }
        }
        System.out.println(returnVal);
    }
}

// 메모리 : 16112KB
// 시간 : 148ms

// curr이 M과 일치 했을 때 함수 미종료 시(Section A 없이):
// 메모리 : 16624KB
// 시간 : 152ms