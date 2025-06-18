package Class_Two;

import java.util.*;
import java.io.*;

public class BOJ_1929 { // 문제 : 소수 구하기
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = inputs[0]; i <= inputs[1]; i++) {
            if(isPrime(i)) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    public static boolean isPrime(int curr){
        if (curr < 2) return false;
        for (int i = 2; i <= Math.sqrt(curr); i++) {
            if (curr % i == 0) return false;
        }
        return true;
    }
}

// 메모리 : 19452KB
// 시간 : 444ms