import java.util.Scanner;

public class p08 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean isValid = true;

        String[] input1 = console.nextLine().split(" ");
        int r = Integer.parseInt(input1[0]);
        int c = Integer.parseInt(input1[1]);
        int[][] matrix = new int[r][c];
        String[] input2 = new String[c];
        for (int i = 0; i < r; i++) {
            input2 = console.nextLine().split(" ");
            for (int j = 0; j < c; j++) {
                matrix[i][j] = Integer.parseInt(input2[j]);
            }


        }

        String input3 = console.nextLine();
        String[] swap = new String[5];
        int temp = 0;

        while (!input3.equals("END")) {

            try {
                swap = input3.split(" ");
            } catch (Exception e) {
                isValid = false;
            }
            if (!swap[0].equals("swap")) {
                isValid = false;
            } else try {
                int i = Integer.parseInt(swap[1]);
                int j = Integer.parseInt(swap[2]);
                temp = matrix[i][j];
                int k = Integer.parseInt(swap[3]);
                int l = Integer.parseInt(swap[4]);
                matrix[i][j] = matrix[k][l];
                matrix[k][l] = temp;
            } catch (Exception e) {
                isValid = false;
            }

            if (!isValid) {
                System.out.println("Invalid input!");
                isValid = true;
            } else {
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        System.out.print(matrix[i][j]);
                        System.out.print(" ");
                    }

                    System.out.println();
                }
            }

            input3 = console.nextLine();
        }
    }
}

