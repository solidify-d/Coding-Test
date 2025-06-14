package Class_Two;

import java.io.*;
import java.util.*;

public class BOJ_2108 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수.
        int repeats = Integer.parseInt(br.readLine());
        int[] inputs = new int[repeats];

        // 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않음.
        for(int i = 0; i < repeats; i++){
            inputs[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(inputs); // findMedian과 findRange는 정렬된 정수 배열을 인자값으로 받는다는 가정 하에 만들어진 함수이기에 미리 정렬.
        // 만약 함수 내에서 각각 정렬을 시도 했다면, 불필요한 정렬이 1회 추가 된 것임으로, 비효율적이기에 이 방법을 채택.

        // 첫째 줄에는 산술평균(N개의 수들의 합을 N으로 나눈 값)을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력.
        System.out.println(findAverage(inputs));

        // 둘째 줄에는 중앙값(N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값)을 출력.
        System.out.println(findMedian(inputs));

        //셋째 줄에는 최빈값(N개의 수들 중 가장 많이 나타나는 값)을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력.
        System.out.println(findMode(inputs));

        //넷째 줄에는 범위(N개의 수들 중 최댓값과 최솟값의 차이)를 출력.
        System.out.println(findRange(inputs));
    }

    public static int findAverage(int[] inputs){
        int temp = 0;

        // 인풋 값을 전부 더한다.
        for(int curr : inputs){
            temp += curr;
        }

        // 1) 정수 나눗셈의 소수점 절단을 방지하기 위해 temp 를 float으로 타입 캐스팅.
        // 2) temp를 정수 배열의 길이로 나누고 .round 내장 함수로 반올림.
        return Math.round((float) temp / inputs.length);
    }

    public static int findMedian(int[] inputsOrdered){
        int arraySize = inputsOrdered.length;

        if(arraySize % 2 == 0){
            // 만약 배열의 길이가 2의 배수라면, 길이를 2로 나눈 값을 N이라 할 때,
            // 중앙값은 [Num(N) + Num(N+1)] / 2가 된다.
            // 그런데 문제를 다시 읽어보니, N은 어차피 홀수이기에 필요 없는 코드임.
            // findAverage와 동일하게 소수점 절단을 방지하기 위한 타입 케스팅과 그 이후 .round를 통한 반올림.
            return Math.round((float) (inputsOrdered[arraySize / 2] + inputsOrdered[arraySize / 2 + 1]) / 2);
            // float 대신 double을 넣으면 오류 발생. 추가적인 검색 필요.
        } else{
            return inputsOrdered[arraySize / 2];
        }
    }

    public static int findMode(int[] inputs) {
        // 정수의 절대값은 4000을 넘지 않는다 하였고,
        // 따로 최소값에 대한 언급은 없었음.
        // 이럴 경우, 최소값은 -4000임을 암묵적으로 의미.
        // numCounts 배열의 길이를 8000으로 맞출 순 있겠지만,
        // 관리하기 용기하기 위해 8001로 길이를 초기화 하였음.
        // 이를 통해 값 그 자체에 4000만큼 더한 값을 인덱스로 활용이 가능해짐.
        int[] numCounts = new int[8001]; // -4000 ~ 4000 → 0 ~ 8000

        // 정수 배열을 돌며 현재 값을 curr 이라 칭할 때,
        // numCounts 배열의 curr + 4000번째의 값을 1씩 더해줌.
        for (int curr : inputs) {
            numCounts[curr + 4000]++;
        }

        // 가장 자주 등장한 횟수가 몇인지를 담을 maxCount 변수.
        int maxCount = 0;

        // numCounts 배열을 순회하며 i번째 인덱스에 있는 값이 현재 maxCount보다 클 경우,
        // maxCount의 값을 numCounts i번째 인덱스에 있는 값으로 갱신 하고,
        // 인덱스값이 아닌 실제 값을 mode 변수에 담음.
        for (int i = 0; i < numCounts.length; i++) {
            if (numCounts[i] > maxCount) {
                maxCount = numCounts[i];
            }
        }

        // 최빈값이 여러개 있을 경우 그 중 두 번째로 작은 값을 출력
        // 최빈값이 몇개인지 모르기에 가변길이를 허용하는 ArrayList 사용.
        List<Integer> modes = new ArrayList<>();

        // numCounts 배열을 순회하며
        // 해당 인덱스에 들어 있는 값이 maxCount값과 동일하다면
        // 최빈값으로 판단 후 modes ArrayList에 추가.
        for(int i = 0; i < numCounts.length; i++){
            if(numCounts[i] == maxCount){
                modes.add(i - 4000); // 인덱스 값을 실제 값으로 수정
            }
            if(modes.size() == 2){
                // 만약 최빈값이 두 개 이상이라면, 두 번째 값을 바로 리턴.
                // numCounts의 경우 -4000부터 시작하기에 자연스레 작은 값 부터 큰 값까지 순차적으로 배열을 순회하게 된다.
                // 따라서 modes에 들어간 두 번째 값이 구 번재로 작은 값이 된다.
                return modes.get(1);
            }
        }

        return modes.get(0); // 최빈값의 갯수가 1이기에 modes ArrayList의 0번째 값을 리턴
    }

    public static int findRange(int[] inputsOrdered){
        int smallest = inputsOrdered[0];
        int largest = inputsOrdered[inputsOrdered.length-1];

        return largest - smallest; // 가장 큰 값 - 가장 작은 값
    }
}

// 메모리 : 49376KB
// 시간 : 520ms
