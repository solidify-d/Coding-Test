package Class_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputNum; i++) {
            String[] userInputs = br.readLine().split(" ");

            int height = Integer.parseInt(userInputs[0]);
            int num = Integer.parseInt(userInputs[2]);

            int floor = num % height == 0 ? height : num % height;
            int room = (int) Math.ceil((double) num / height);

            System.out.printf("%d%02d\n", floor, room);  // 층수 + 두자리 방 번호
        }
    }
}