import java.util.Scanner;

public class BOJ_1463{
    static int makeOne(int X, int count){
        if(X < 2){
            return count;
        }
        return Math.min(makeOne(X / 2, count + (X % 2) + 1), makeOne(X / 3, count + (X % 3) + 1));
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int X = scan.nextInt();
        System.out.println(makeOne(X, 0));
    }
}