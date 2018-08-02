import java.util.Scanner;

public class p05 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input1 = console.nextLine().split(" ");
        int r = Integer.parseInt(input1[0]);
        int c = Integer.parseInt(input1[1]);

        int[][] matrix = new int[r][c];

        String[] input2 = new String[c];

        for (int i = 0; i < r; i++){
            input2 = console.nextLine().split(" ");
            for (int j = 0; j < c; j++){
                matrix[i][j] = Integer.parseInt(input2[j]);
            }
        }

        int[] bestIndex = {0, 0};
        int bestSum = Integer.MIN_VALUE;

        int[] currentIndex = {0, 0};
        int currentSum = 0;

        for (int i = 0; i < r-2; i++){
            for (int j = 0; j < c-2; j++){
                currentIndex[0] = i;
                currentIndex[1] = j;
                currentSum = 0;
                for(int k = i; k < i+3; k++){
                    for (int l = j; l < j+3; l++){
                        currentSum += matrix[k][l];
                    }
                }
                if (currentSum>bestSum){
                    bestIndex[0] = currentIndex[0];
                    bestIndex[1] = currentIndex[1];
                    bestSum = currentSum;
                }
            }
        }

        System.out.println("Sum = " + bestSum);
        for (int i = bestIndex[0]; i < bestIndex[0]+3; i++){
            for (int j = bestIndex[1]; j < bestIndex[1]+3; j++){
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
