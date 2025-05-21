import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 9; i ++){
            System.out.println(input + " * " + i + " = " + input*i);
        }

        br.close();
    }
}

// 메모리 : 16196KB
// 시간 : 132ms