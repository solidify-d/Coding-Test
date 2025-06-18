package Silver;

import java.util.*;
import java.io.*;

public class BOJ_11866 { // 문제 : 요세푸스 문제 0
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= inputs[0]; i++) {
            queue.add(i);
        }

        sb.append("<");

        while (!queue.isEmpty()) {
            for (int i = 0; i < inputs[1] - 1; i++) {
                queue.add(queue.poll()); // 앞에서 K-1명은 다시 뒤로 보냄
            }
            sb.append(queue.poll()); // K번째 사람 제거
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
}

//