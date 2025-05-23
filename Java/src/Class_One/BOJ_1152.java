package Class_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim(); // 앞뒤 공백 제거

        if (input.isEmpty()) {
            System.out.println(0); // 입력이 공백뿐일 경우
        } else {
            String[] words = input.split("\\s+"); // 하나 이상의 공백 기준으로 split
            System.out.println(words.length);
        }

        br.close();
    }
}