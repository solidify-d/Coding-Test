import java.io.*;
import java.util.*;

public class Main {

    // Node 클래스 : 각 문서의 중요도와 추적 대상 여부를 함께 저장
    static class Node {
        int priority;   //문서의 중요도
        boolean isTracked;  // 추적대상 문서인지 여부

        public Node(int priority, boolean isTracked) {
            this.priority = priority;
            this.isTracked = isTracked;
        }
    }

    public static void main(String[] args) throws IOException{
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(br.readLine());  //테스트케이스 개수

        for (int i = 0; i < testCount; i++) { //테스트케이스만큼 for이 도는거지?
            // 한 줄 입력을 공백 기준으로 분할하고, 각 문자열을 정수로 변환하여 int배열로 저장
            String[] inputs = br.readLine().split(" ");
            int N = Integer.parseInt(inputs[0]); // N은 문서 중요도의 개수
            int M = Integer.parseInt(inputs[1]); // M은 내가 출력해야 할 중요도의 초기 index

            String[] priorities = br.readLine().split(" ");
            int[] pr = new int[priorities.length];
            int index = 0;
            for (String p : priorities) {
                pr[index] = Integer.parseInt(p);
                index++;
            }

            LinkedList<Node> desk = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                boolean isTracked = (j == M); //현재 문서가 추적 대상인지 여부 결정
                desk.add(new Node(pr[i], isTracked)); // Node 타입 Linkedlist의 desk에 node를 저장한다.
            }

            int count = 0; // 몇 번째에 출력할 건지 count 변수

            if (desk.size() == 1) {
                count++;
                System.out.println(count);
                continue;
            }

            while (!desk.isEmpty()) {
                Node curr = desk.poll(); // 맨 앞의 문서 curr 저장
                boolean high = false;
                for (Node temp : desk) {
                    if (temp.priority > curr.priority) {
                        high = true;
                        break;
                    }
                }
                if (!high) {
                    count++;
                    if (curr.isTracked) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    desk.addLast(curr);
                }

            }
        }
    }
}