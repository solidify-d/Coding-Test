package Class_Two;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15829 {

    static final int MOD = 1234567891;
    static final int R = 31;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String seq = br.readLine();
        br.close();
        System.out.println(calc(seq, length));
    }

    public static long power(long base, int exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    public static long calc(String seq, int length){
        long result = 0;
        for(int i = 0; i < length; i++){
            int temp = seq.charAt(i) - 'a' + 1;
            result = (result + (temp * power(R, i)) % MOD) % MOD;
        }
        return result;
    }
}