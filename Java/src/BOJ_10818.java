import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        int max = Integer.parseInt(inputs[0]);
        int min = Integer.parseInt(inputs[0]);

        for(int i = 0; i < inputNum; i++){
            if (Integer.parseInt(inputs[i]) > max){
                max = Integer.parseInt(inputs[i]);
            }
            if (Integer.parseInt(inputs[i]) < min){
                min = Integer.parseInt(inputs[i]);
            }
        }

        System.out.println(min + " " + max);

        br.close();
    }
}