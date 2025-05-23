package Class_One;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set; // 인터페이스 (왼쪽 타입 선언용)
import java.util.HashSet;  // 구현 클래스 (오른쪽 객체 생성용)

public class BOJ_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 중복을 허용하지 않는 Set 컬렉션 생성
        // 순서를 보장하지 않지만, 성능이 가장 빠른 HashSet 사용.
        // 만약 입력한 순서를 유지 해야 한다면 LinkedHashSet, 자동 정렬을 원한다면 TreeSet 사용.
        Set<Integer> remainderSet = new HashSet<>();

        // 총 10개의 정수를 입력받는다
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            int remainder = num % 42;
            remainderSet.add(remainder); // 나머지를 Set에 추가 (중복 자동 제거)
        }

        br.close();

        // 서로 다른 나머지의 개수를 출력
        System.out.println(remainderSet.size());
    }
}


// 메모리 :
// 시간 :