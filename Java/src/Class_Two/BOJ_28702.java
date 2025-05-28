package Class_Two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_28702 { // 문제 : FizzBuzz
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 3; // 첫 번째 input 값이 숫자일 경우 해당 값에 +3을 하기 위해 count 를 3으로 초기화
        for(int i = 0; i < 3; i++){ // 최대 3번까지 루프를 돌며 FizzBuzz, Fizz, Buzz가 아닌 값을 탐색
            String temp = br.readLine();
            if(temp.equals("FizzBuzz") || temp.equals("Fizz") || temp.equals("Buzz")){
                count--; // 다음 인풋 값 받기 전 count를 1 감소
            }
            else{ // FizzBuzz, Fizz, Buzz String이 아닌 경우 이는 숫자임을 뜻함 (3번 연속으로 3 혹은 5의 배수인 수열 존재 X)
                br.close(); // 더 이상 인풋 값 받지 않음
                count += Integer.parseInt(temp); // 현재 count 값에 인풋 정수값 더함
                if(count % 5 == 0 && count % 3 == 0){ // 3의 배수이면서 5의 배수
                    System.out.println("FizzBuzz");
                    return; // 함수 종료
                }
                else if(count % 3 == 0){ // 3의 배수이지만 5의 배수가 아님
                    System.out.println("Fizz");
                    return; // 함수 종료
                }
                else if(count % 5 == 0){ // 5의 배수이지만 3의 배수가 아님
                    System.out.println("Buzz");
                    return; // 함수 종료
                }
                else{
                    System.out.println(count); // 3의 배수도 아니고 5의 배수도 아님
                    return; // 함수 종료
                }
            }
        }
    }
}

// 메모리 : 14308KB
// 시간 : 104ms

// 문제 링크 : https://www.acmicpc.net/problem/28702