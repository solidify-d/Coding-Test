package Class_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        br.close();
        int[] notes = new int[8];

        // 문자열 배열을 정수 배열로 변환
        for (int i = 0; i < 8; i++) {
            notes[i] = Integer.parseInt(inputs[i]);
        }

        // 판별 변수 초기화
        boolean isAscending = true;
        boolean isDescending = true;

        for (int i = 0; i < 7; i++) {
            if (notes[i] < notes[i + 1]) {
                isDescending = false;
            } else if (notes[i] > notes[i + 1]) {
                isAscending = false;
            }
        }

        // 결과 출력
        if (isAscending) {
            System.out.println("ascending");
        } else if (isDescending) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}

// 메모리 : 14212KB
// 시간 : 128ms