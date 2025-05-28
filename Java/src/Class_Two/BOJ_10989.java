package Class_Two;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10989 { // 문제 : 수 정렬하기 3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeats = Integer.parseInt(br.readLine());
        int[] nums = new int[repeats];

        for(int i = 0; i < repeats; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Arrays.sort(nums);
        printArray(nums);
    }

    public static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append('\n');
        }
        System.out.println(sb);
    }
}

// 메모리 : 364540KB
// 시간 : 2376ms