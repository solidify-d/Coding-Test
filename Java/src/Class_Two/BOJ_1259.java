package Class_Two;

import java.io.*;

public class BOJ_1259 { // 문제: 팰린드롬수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true){
            String curr = br.readLine();
            if (curr.equals("0")) break;
            boolean isPalindrome = true;

            for(int i = 0; i < curr.length() / 2; i++){
                if(curr.charAt(i) != curr.charAt(curr.length() - 1 - i)){
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome){
                sb.append("yes\n");
            }
            else{
                sb.append("no\n");
            }
        }
        System.out.println(sb);
    }
}

// 메모리 : 14080KB
// 시간 : 104ms