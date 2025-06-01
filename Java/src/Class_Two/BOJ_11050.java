package Class_Two;

import java.io.*;
import java.util.*;

public class BOJ_11050 { // 문제 : 이항 계수 1

    public static int factorial(int input){
        if(input == 1 || input == 0){
            return 1;
        } else{
            return input * factorial(input - 1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int returnVal = (factorial(inputs[0])) / (factorial(inputs[1]) * factorial(inputs[0] - inputs[1]));

        System.out.print(returnVal);
    }
}

// 메모리 : 14396KB
// 시간 : 108ms