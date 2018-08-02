import java.util.Scanner;

public class p01 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        char pattern = input[1].charAt(0);
        int[][] matrix = new int[n][n];

        if (pattern == 'A') {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = i + j * n + 1;
                }
            }
        } else if (pattern == 'B') {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    switch (j % 2) {
                        case 0:
                            matrix[i][j] = i + j * n + 1;
                            break;
                        case 1:
                            matrix[i][j] =  (j+1)*n - i;
                            break;
                    }
                }
            }
        }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j]);
                    System.out.print(' ');
                }
                System.out.println();
            }
        }
    }
