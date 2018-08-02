import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShockWave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = reader.readLine().split(" ");
        Integer n = Integer.parseInt(dimensions[0]);
        Integer m = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[n][m];
        String[] tokens = reader.readLine().split(" ");
        while(!"Here".equals(tokens[0])){
            Integer x1 = Integer.parseInt(tokens[0]);
            Integer y1 = Integer.parseInt(tokens[1]);
            Integer x2 = Integer.parseInt(tokens[2]);
            Integer y2 = Integer.parseInt(tokens[3]);
            for(int i = x1; i <= x2; i++){
                for(int j = y1; j <= y2; j++){
                    matrix[i][j]++;
                }
            }
            tokens = reader.readLine().split(" ");
        }
        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
