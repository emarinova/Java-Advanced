import java.util.Scanner;

public class p03 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        String[] input = new String[n];
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++){
            input = console.nextLine().split(" ");
            for (int j = 0; j < n; j++){
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        int diagonal1 = 0;
        int diagonal2 = 0;

        for (int i = 0; i < n; i++){
            diagonal1 += matrix[i][i];
            diagonal2 += matrix[i][n-1-i];
        }

        System.out.println(Math.abs(diagonal1-diagonal2));
    }
}
