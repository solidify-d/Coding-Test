package Class_One;

import java.util.Scanner;

public class BOJ_11720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int returnVal = 0;

        int inputNum = Integer.parseInt(scanner.nextLine()); // 사용자로부터 숫자 문자열의 길이 입력
        String input = scanner.nextLine(); // 사용자로부터 숫자 문자열 입력

        for (int i = 0; i < inputNum; i++) {
            returnVal += Character.getNumericValue(input.charAt(i)); // 문자 → 숫자 변환
        }

        System.out.print(returnVal);

        scanner.close();
    }
}