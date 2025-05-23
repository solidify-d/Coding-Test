import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10809 { // 문제 : 알파벳 찾기

    // 문제 설명: 알파벳 소문자로만 이루어진 단어가 있을 때, 각각의 알파벳에 대해서 처음 등장하는 위치를 출력하라.
    // 단, 등장하지 않는 알파벳의 경우 -1를 출력하라.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        br.close(); // 더 이상 사용자로부터 받을 인풋 값이 없으므로, 원치 않은 인풋을 방지하기 위해 버퍼리더를 닫음.

        int[] values = new int[26]; // 알파벳 a~z → 총 26개 → 26 크기의 int list 초기화 values[0] -> a, values[25] -> z

        // 초기값 전부 -1로 설정
        // 이렇게 초기값을 -1로 설정한 이유로는, 이 문제에서 요구하는 답은 각 알파벳의 `처음 등장한 위치`이기 때문이라는 생각.
        // 인덱스는 0부터 시작을 하게 되는데, 배열의 초기값 또한 0부터 시작을 하게 되기에 첫 알파벳으로 나왔기에 0이라는 값을 갖고 있는 것인지,
        // 아니면 그냥 배열 초기값으로서 0을 가지고 있는지 프린트값 만으론 확인이 불가능한 문제가 발생함.
        // 따라서 문제에서도 한번도 사용되지 않은 알파벳의 경우 -1로 지정하라 한 것 같다.

        Arrays.fill(values, -1); // 2025-05-22에서 언급 된 Arrays 내 .fill 내장 함수 사용

        // 단어를 순회하며 처음 등장한 알파벳 위치 기록
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i); // String 내 내장 함수인 charAt를 통해 단어의 각 character를 추출

            // 추출한 character에서 'a' 만큼 빼줌으로서 character의 값을 index화
            int index = c - 'a'; // 'a' -> 0, 'b' -> 1, ..., 'z' -> 25
            if (values[index] == -1) { // index화 시킨 위치에 -1이 저장되어 있다면 이는 아직 등장한 적 없는 알파벳이라는 것을 알 수 있다.
                values[index] = i; // 처음 등장한 위치만 기록
            } // 만약 -1이 아닌 경우 이미 등장했던 알파벳이고, 본 문제에서는 `처음 등장한 위치`만 기록을 하면 되기에 pass.
        }

        // 결과 출력 섹션
        // StringBuilder는 내부적으로 가변적인 배열을 사용하여 문자열을 수정하므로,
        // 새로운 객체를 생성하지 않고도 문자열을 효율적으로 이어붙일 수 있다.
        // 아래에 더 자세히 설명 해 두었습니다!
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            returnVal.append(values[i]).append(" ");
        }

        // StringBuilder 내부 함수인 .trim을 사용하여 마지막 끝 공백 제거
        System.out.println(returnVal.toString().trim());
    }
}

// 메모리 : 14252KB
// 시간 : 104ms
// 링크 : https://www.acmicpc.net/problem/10809