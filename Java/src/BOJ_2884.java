import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ_2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] userInputs = br.readLine().split(" ");

        int h = Integer.parseInt(userInputs[0]);
        int m = Integer.parseInt(userInputs[1]);

        m = m - 45;
        if (m < 0){
            m += 60;
            h -= 1;
            if (h < 0){
                h = 23;
            }
        }

        System.out.println(h + " " + m);
    }
}