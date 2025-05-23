import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1008 { // 문제 : A/B
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        double first = Double.parseDouble(nums[0]);
        double second = Double.parseDouble(nums[1]);

        System.out.printf("%.13f", first / second);
    }
}
// 메모리 : 14560KB
// 시간 : 108ms
// 링크 : https://www.acmicpc.net/problem/1008

// 정말 느끼는게 많았던 문제였다. 나는 계속해서 Float을 이용하여 이 문제를 풀려고 했지만, 어떤 방식으로 시도를 해봐도 계속해서 실패했다.
// 그래서 해결책을 찾고자 GPT에게 물어봤더니, flaot의 경우 정밀도 부족으로 오답 처리가 될 수 있고, 이를 방지하기 위해서는 long이나 double을 써야 한다는 조언을 해주었다.
// 그렇게 조언대로 수정하니 바로 정답처리 되었다.