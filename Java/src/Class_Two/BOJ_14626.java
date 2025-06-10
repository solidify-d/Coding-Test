package Class_Two;

import java.io.*;

public class BOJ_14626 { // 문제: ISBN
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = 0;
        int multNum = 1;
        String[] inputs = br.readLine().split("");
        for(int i = 0; i < inputs.length; i++){
            if (inputs[i].equals("*")){
                if (i % 2 != 0){
                    multNum = 3;
                }
                continue;
            }
            int temp = Integer.parseInt(inputs[i]);
            if(i % 2 != 0){
                m = m + 3 * temp;
            }else{
                m += temp;
            }
        }

        for(int i = 0; i < 10; i++){
            int temp = m;
            temp = m + i * multNum;
            if (temp % 10 == 0){
                System.out.println(i);
                return;
            }
        }
    }
}

// 메모리 : 14304KB
// 시간 : 100ms