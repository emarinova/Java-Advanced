import java.util.Scanner;

public class p02 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        String[][] matrix = new String[r][c];

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                matrix[i][j] = new StringBuilder().append((char)(i+97)).append((char)(i+j+97)).append((char)(i+97)).toString();
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
