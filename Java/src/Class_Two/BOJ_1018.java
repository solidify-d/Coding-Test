package Class_Two;

import java.io.*;
import java.util.*;

public class BOJ_1018 {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] repeats = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] inputs = new String[repeats[0]];

        String startBlack = "BWBWBWBW";
        String startWhite = "WBWBWBWB";

        for(int i = 0; i < repeats[0]; i++){
            inputs[i] = br.readLine();
        }

        for(int i = 0; i < repeats[0] - 7; i++){
            for(int j = 0; j < inputs[0].length(); j++){
                inputs[i].substring(i, i+8);
            }
        }
    }
}
