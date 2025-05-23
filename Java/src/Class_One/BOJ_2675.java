package Class_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) { // br.readLine은 다음 인풋이 없을 시 null 반환
            String[] input = line.split(" "); // line에 직접 split()

            int repeats = 0; // 반복 횟수 초기화
            String text = ""; // 스트링 초기화

            if (input.length > 1) {
                repeats = Integer.parseInt(input[0]);
                text = input[1];
            } else { // 인수가 하나인 경우 반복문 시작 지점으로 되돌아가기
                continue;
            }
    
            for (int i = 0; i < text.length(); i++) {
                for (int y = 0; y < repeats; y++) {
                    System.out.print(text.charAt(i));
                }
            }
            System.out.println(); // 각 케이스 끝 줄바꿈
        }
        br.close();
    }
}

// 메모리 : 14144KB
// 시간 : 152ms