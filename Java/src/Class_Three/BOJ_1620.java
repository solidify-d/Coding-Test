package Class_Three;

import java.util.*;
import java.io.*;

public class BOJ_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashMap<Integer, String> pokemonsIndex = new HashMap<>();
        HashMap<String, Integer> pokemonsName = new HashMap<>();

        for (int i = 1; i <= inputs[0]; i++) {
            String name = br.readLine();
            pokemonsIndex.put(i, name);
            pokemonsName.put(name, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < inputs[1]; i++) {
            String question = br.readLine();

            try {
                if (pokemonsIndex.containsKey(Integer.parseInt(question))) {
                    sb.append(pokemonsIndex.get(Integer.parseInt(question))).append("\n");
                }
            } catch (Exception e) {
                sb.append(pokemonsName.get(question)).append("\n");
            }
        }

        System.out.println(sb);
    }
}

// 메모리 : 101644KB
// 시간 : 680ms
// 링크 : https://www.acmicpc.net/problem/1620