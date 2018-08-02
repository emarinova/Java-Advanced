
import java.util.Scanner;

public class p13_RecursiveFibonacci {
    private static long[] memo;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        memo = new long[n+2];
        System.out.println(getFibonacci(n));
    }

    private static long getFibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (memo[n]!=0) {
            return memo[n];
        }
        memo[n] = getFibonacci(n-1) + getFibonacci(n-2);
        return memo[n];
    }
}
