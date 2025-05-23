package Class_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int participants = Integer.parseInt(br.readLine());
        String[] sizes = br.readLine().split(" ");
        String[] packageCount = br.readLine().split(" ");
        br.close();
        int numShirtPack = 0;
        for (String size : sizes) {
            numShirtPack += (int) Math.ceil(((double) Integer.parseInt(size)) / Integer.parseInt(packageCount[0]));
        }
        int numPencilPack = participants / Integer.parseInt(packageCount[1]);
        int remainder = participants - numPencilPack * Integer.parseInt(packageCount[1]);
        System.out.println(numShirtPack);
        System.out.println(numPencilPack + " " + remainder);
    }
}


// 메모리 : KB
// 시간 : ms