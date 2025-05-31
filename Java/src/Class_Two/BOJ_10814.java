import java.io.*;

public class BOJ_10814 { // 문제 : 나이순 정렬
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 처리하기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: 전체 회원 수 입력
        int repeats = Integer.parseInt(br.readLine());

        // 나이 범위가 1~200이므로 인덱스 0~200까지 사용할 수 있도록 배열 생성
        // 각 인덱스는 해당 나이의 회원 정보를 누적할 StringBuilder 객체
        StringBuilder[] sb = new StringBuilder[201];

        // 배열 내 각 StringBuilder 인스턴스를 초기화 (null 방지)
        for (int i = 0; i <= 200; i++) {
            sb[i] = new StringBuilder();
        }

        // 입력받은 회원 정보를 나이순 버킷(StringBuilder)에 누적
        for (int i = 0; i < repeats; i++) {
            // "나이 이름" 형식으로 입력받고 공백 기준으로 분리
            String[] temp = br.readLine().split(" ");
            int age = Integer.parseInt(temp[0]); // 나이 파싱
            String name = temp[1];               // 이름 파싱

            // 해당 나이 인덱스의 StringBuilder에 "나이 이름\n" 형식으로 추가
            // 입력 순서 그대로 누적되므로 안정 정렬(stable sort)이 자연스럽게 만족됨
            sb[age].append(age).append(" ").append(name).append("\n");
        }

        // 최종 출력을 위한 StringBuilder
        StringBuilder returnVal = new StringBuilder();

        // 나이순으로 인덱스를 순회하며 각 나이에 해당하는 회원 정보들을 순서대로 연결
        for (int i = 0; i <= 200; i++) {
            returnVal.append(sb[i]); // 해당 나이에 저장된 회원 정보 추가
        }

        // 결과를 한 번에 출력
        System.out.println(returnVal);
    }
}

// 메모리: 51436KB
// 시간: 444ms