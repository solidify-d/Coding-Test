package Silver;

import java.io.*;
import java.util.*;

public class BOJ_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCardsChosen = Integer.parseInt(br.readLine());

        Map<Integer, Integer> cardMap = new TreeMap<>();

        int[] cardsChosen = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] cardsToCompare = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numCardsChosen; i++) {
            cardMap.put(cardsChosen[i], cardMap.getOrDefault(cardsChosen[i], 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for(int curr : cardsToCompare){
            if(cardMap.containsKey(curr)){
                sb.append("1 ");
                if(cardMap.get(curr) == 1){
                    cardMap.remove(curr);
                } else {
                    cardMap.put(curr, cardMap.get(curr) - 1);
                }
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb);
    }
}
