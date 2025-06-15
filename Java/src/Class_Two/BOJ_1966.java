package Class_Two;

import java.io.*;
import java.util.*;

public class BOJ_1966 { // 문제 : 프린터 큐

    // Node 클래스: 각 문서의 중요도와 추적 대상 여부를 함께 저장
    static class Node {
        int priority;      // 문서의 중요도
        boolean isTracked; // 추적 대상 문서인지 여부

        public Node(int priority, boolean isTracked){
            this.priority = priority;
            this.isTracked = isTracked;
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int repeats = Integer.parseInt(br.readLine()); // 테스트케이스 개수 입력

        for (int i = 0; i < repeats; i++) {
            // 한 줄 입력을 공백 기준으로 분할하고, 각 문자열을 정수로 변환하여 int 배열로 저장
            int[] inputs = Arrays.stream(br.readLine().split(" "))      // 입력받은 한 줄 문자열을 공백(" ") 기준으로 나눠 스트림 생성
                    .mapToInt(Integer::parseInt)                              // 각 문자열을 정수(int)로 파싱
                    .toArray();                                               // 파싱된 값들을 int[] 배열로 변환하여 저장

            // 문서들의 중요도 입력 (위와 동일한 방법 사용)
            int[] priorities = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int numPrints = inputs[0]; // 문서 총 개수
            int trackIndex = inputs[1];   // 추적 대상 문서의 초기 인덱스

            LinkedList<Node> queue = new LinkedList<>();
            // 큐는 안에 인덱스가 없음... LinkedList --> 인덱스가 있음

            // 큐 초기화: 각 문서를 Node 객체로 만들어 큐에 삽입
            for (int j = 0; j < numPrints; j++) {
                boolean isTracked = (j == trackIndex); // 현재 문서가 추적 대상인지 여부 설정
                queue.add(new Node(priorities[j], isTracked));
            }

            int count = 0; // 인쇄 순서를 카운트하는 변수

            // 문서가 하나뿐이라면 바로 출력
            if (queue.size() == 1) {
                count++;
                System.out.println(count);
                continue;
            }

            // 큐가 빌 때까지 반복
            while (!queue.isEmpty()) {
                Node curr = queue.poll(); // 큐의 맨 앞 문서 꺼냄

                // 큐 안에 curr보다 더 높은 중요도가 있는 문서가 있는지 확인
                boolean hasHigherPriority = false;

                for (Node temp : queue) {
                    if (temp.priority > curr.priority) {
                        hasHigherPriority = true;
                        break;
                    }
                }

                if (hasHigherPriority) {
                    // 더 높은 중요도가 존재하면 현재 문서를 다시 큐 뒤로 보냄
                    queue.addLast(curr);
                } else {
                    // 그렇지 않으면 문서 인쇄
                    count++;
                    if (curr.isTracked) {
                        // 현재 문서가 추적 대상이면 인쇄 순서를 출력하고 종료
                        System.out.println(count);
                        break;
                    }
                }
            }
        }
    }
}

// 메모리: 15540KB
// 시간 : 140ms