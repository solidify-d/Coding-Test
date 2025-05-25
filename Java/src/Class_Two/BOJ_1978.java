package Class_Two;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeats = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int returnVal = 0;

        for (int i = 0; i < repeats; i++) {
            int curr = Integer.parseInt(inputs[i]);
            if (isPrime(curr)) {
                returnVal++;
            }
        }

        System.out.print(returnVal);
    }

    // 소수 판별 함수
    public static boolean isPrime(int n) {
        // 소수는 1보다 큰 자연수 중 1과 자기 자신만을 약수로 가지는 수이기에 1과 음수는 소수가 아니다.
        if (n < 2){
            return false;
        }
        // 어떤 자연수가 합성수라면 반드시 그 약수 중 하나는 √n 이하에 존재한다는 성질 덕분에,
        // 소수 판별은 √n까지만 검사해도 충분하다.
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}

// 메모리 : 14184KB
// 시간 : 108ms
