import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2741 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        for(int i = 1; i <= input; i++){
            System.out.println(i);
        }

        br.close();
    }
}

// 메모리 : 31172KB
// 시간 : 840ms