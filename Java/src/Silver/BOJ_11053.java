package Silver;

import java.io.*;             // 입력을 위한 패키지
import java.util.*;           // Arrays 사용을 위한 패키지

public class BOJ_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 수열의 길이 n을 입력받음

        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        // 공백으로 구분된 수열의 각 숫자를 입력받아 int 배열로 저장

        int[] dp = new int[n];
        // dp[i] : i번째 수를 마지막 원소로 하는 가장 긴 증가하는 부분 수열의 길이

        Arrays.fill(dp, 1);
        // 최소한 자기 자신만 포함하는 수열이 되므로, 모든 dp[i]를 1로 초기화

        // 이중 반복문으로 모든 이전 원소들과 비교
        for (int i = 1; i < n; i++) {         // 현재 수의 위치 i
            for (int j = 0; j < i; j++) {     // i보다 앞에 있는 수의 위치 j
                if (nums[j] < nums[i]) {      // 앞에 있는 수가 현재 수보다 작다면 (증가하는 조건 만족)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    // dp[i]는 이전 증가 수열 길이 + 1 과 기존 값 중 더 큰 값으로 갱신
                }
            }
        }

        int max = Arrays.stream(dp).max().getAsInt();
        // dp 배열에서 최댓값을 찾아 가장 긴 증가하는 부분 수열의 길이를 구함

        System.out.println(max);
        // 결과 출력
    }
}
