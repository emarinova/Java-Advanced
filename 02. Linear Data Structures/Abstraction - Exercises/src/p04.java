import java.util.Scanner;

public class p04 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input1 = console.nextLine().split(" ");
        int r = Integer.parseInt(input1[0]);
        int c = Integer.parseInt(input1[1]);

        String[][] matrix = new String[r][c];

        String[] input2 = new String[c];

        for (int i = 0; i < r; i++){
            input2 = console.nextLine().split(" ");
            for (int j = 0; j < c; j++){
                matrix[i][j] = input2[j];
            }
        }

        int counter = 0;

        for (int i = 0; i < r-1; i++){
            for (int j = 0; j < c-1; j++) {
                if ((matrix[i][j].equals(matrix[i+1][j])) &&
                        (matrix[i][j].equals(matrix[i+1][j+1])) &&
                            (matrix[i][j].equals(matrix[i][j+1]))){
                    counter++;
                }
            }
        }

        System.out.println(counter);
    }
}
