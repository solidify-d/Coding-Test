package Class_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1330 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        if (Integer.parseInt(inputs[0]) > Integer.parseInt(inputs[1])) {
            System.out.println(">");
        } else if (Integer.parseInt(inputs[0]) < Integer.parseInt(inputs[1])) {
            System.out.println("<");
        } else {
            System.out.println("==");
        }
    }
}