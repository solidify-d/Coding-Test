package Class_Two;

import java.util.*;
import java.io.*;

public class BOJ_10773 { // 문제 : 제로1
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int repeats = Integer.parseInt(br.readLine());

        for (int i = 0; i < repeats; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                stack.pop();
            }
            else{
                stack.push(temp);
            }
        }

        int result = 0;
        for (int num : stack) {
            result += num;
        }

        System.out.println(result);
    }
}

// 메모리 : 24164KB
// 시간 : 208ms