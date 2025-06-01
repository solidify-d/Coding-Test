package Class_Two;

import java.io.*;
import java.util.*;

public class BOJ_11651 { // 문제: 좌표 정렬하기 2

    // 좌표를 표현할 클래스 정의
    public static class Coord {
        int x;
        int y;

        // 생성자: x와 y값 초기화
        public Coord(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 좌표 개수 입력
        int repeats = Integer.parseInt(br.readLine());

        // 좌표를 저장할 리스트 생성
        ArrayList<Coord> coords = new ArrayList<>();

        // 입력받은 좌표들을 리스트에 저장
        for(int i = 0; i < repeats; i++){
            String[] temp = br.readLine().split(" ");
            Coord coord = new Coord(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            coords.add(coord);
        }

        br.close();

        // 정렬: y 오름차순, y가 같다면 x 오름차순
        coords.sort((c1, c2) -> {
            if (c1.y != c2.y) {
                return Integer.compare(c1.y, c2.y); // y 오름차순
            } else {
                return Integer.compare(c1.x, c2.x); // y가 같다면 x 오름차순
            }
        });

        // 출력 성능을 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < repeats; i++){
            sb.append(coords.get(i).x).append(" ").append(coords.get(i).y).append("\n");
        }

        // 결과 출력
        System.out.print(sb);
    }
}

// 메모리 사용량: 63564KB
// 실행 시간: 792ms
