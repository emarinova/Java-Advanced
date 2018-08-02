import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p06_StringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rotate = reader.readLine();
        int degrees = Integer.parseInt(rotate.substring(7, rotate.length()-1));
        List<String> inputs = new ArrayList<>();
        String input = reader.readLine();
        while(!input.equals("END")){
            inputs.add(input);
            input = reader.readLine();
        }
        char[][] matrix = fillTheMatrix(inputs);

        degrees/=90;
        while(degrees>4){
            degrees-=4;
        }

       if(degrees==0||degrees==4){
           printMatrix(matrix);
       } else if(degrees==3){
           printMatrix(rotate90(rotate90(rotate90(matrix))));
       } else if(degrees==2){
           printMatrix(rotate90(rotate90(matrix)));
       } else if(degrees==1){
           printMatrix(rotate90(matrix));
       }
    }

    private static char[][] fillTheMatrix(List<String> list) {
        int longestString = 0;
        for (String string:list){
            if(string.length()>longestString){
                longestString=string.length();
            }
        }
        char[][] matrix = new char[list.size()][longestString];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < list.get(i).length(); j++){
                matrix[i][j]=list.get(i).charAt(j);
            }
        }
        return matrix;
    }

    private static void printMatrix(char[][] strings) {
        for(int i = 0; i < strings.length; i++){
            for(int j = 0; j < strings[i].length; j++){
                System.out.print(strings[i][j]==0?" ":strings[i][j]);
            }
            System.out.println();
        }
    }



    private static char[][] rotate90(char[][] matrix) {
        char[][] rotatedMatrix = new char[matrix[0].length][matrix.length];
        for(int i = 0; i < rotatedMatrix.length; i++){
            for(int j = 0; j < rotatedMatrix[i].length; j++){
                rotatedMatrix[i][j] = matrix[rotatedMatrix[i].length-j-1][i];
            }
        }
        return rotatedMatrix;
    }
}
