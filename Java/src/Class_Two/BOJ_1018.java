package Class_Two;

import java.io.*;
import java.util.*;

public class BOJ_1018 {
    public static int countDiff(StringBuilder first, StringBuilder second){
        int count = 0;
        for(int i = 0; i < first.length(); i++){
            if(first.charAt(i) != second.charAt(i)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] repeats = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuilder startWhite = new StringBuilder();
        StringBuilder startBlack = new StringBuilder();
        char temp = 'W';
        boolean first = true;

        for(int i = 0; i < repeats[0]; i++) {
            for (int z = 0; z < repeats[1]; z++) {
                if (first) {
                    startWhite.append('W');
                    startBlack.append('B');
                    first = false;
                } else {
                    if (temp == 'W') {
                        startWhite.append('B');
                        startBlack.append('W');
                        temp = 'B';
                    } else {
                        startWhite.append('W');
                        startBlack.append('B');
                        temp = 'W';
                    }
                }
            }
            if (temp == 'W') {
                temp = 'B';
            } else {
                temp = 'W';
            }
            startWhite.append('\n');
            startBlack.append('\n');
        }

        StringBuilder input = new StringBuilder();
        for(int i = 0; i < repeats[0]; i++){
            input.append(br.readLine()).append("\n");
        }
        System.out.println(Math.min(countDiff(input, startBlack), countDiff(input, startWhite)));
    }
}
