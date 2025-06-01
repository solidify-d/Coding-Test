import java.io.*;
import java.util.*;

public class BOJ_11650 { // 문제: 좌표 정렬하기 1

    // 좌표를 저장할 클래스 정의
    public static class Coord {
        int x;
        int y;

        // 생성자: x좌표와 y좌표를 받아 초기화
        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: 좌표의 개수 입력 받기
        int repeats = Integer.parseInt(br.readLine());

        // 입력받은 좌표들을 저장할 리스트
        ArrayList<Coord> coords = new ArrayList<>();

        // 좌표 입력 받기
        for (int i = 0; i < repeats; i++) {
            String[] temp = br.readLine().split(" ");
            Coord coord = new Coord(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            coords.add(coord); // 리스트에 좌표 객체 추가
        }

        br.close(); // 입력 스트림 닫기

        // 정렬: x 오름차순, x가 같으면 y 오름차순
        coords.sort((p1, p2) -> {
            if (p1.x != p2.x) {
                return Integer.compare(p1.x, p2.x); // x 오름차순
            } else {
                return Integer.compare(p1.y, p2.y); // x가 같으면 y 오름차순
            }
        });

        // 출력 결과를 StringBuilder에 저장 (출력 성능 최적화)
        StringBuilder sb = new StringBuilder();
        for (Coord p : coords) {
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }

        // 최종 출력
        System.out.print(sb);
    }
}

// 메모리 사용량: 59844KB
// 실행 시간: 756ms
