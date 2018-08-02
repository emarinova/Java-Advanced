import java.util.Scanner;

public class p07 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = new String[4];
        int r = 4;
        int c = 0;
        for (int i = 0; i < 4; i++)
        {
            input[i] = console.nextLine();
            if (input[i].length() > c){
                c = input[i].length();
            }
        }
        Character[][] matrix = new Character[r][c];
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                try {
                    matrix[i][j] = input[i].charAt(j);
                } catch (Exception ex) {
                    matrix[i][j] = null;
                }
            }
        }

        String directions = console.nextLine();

        int[] pos = {0, 0};
        int coins = 0;
        int walls = 0;

        for (int i = 0; i < directions.length(); i++){
            switch (directions.charAt(i)){
                case '>': try {
                    if (matrix[pos[0]][pos[1]+1] == null) {
                        walls++;
                    } else {
                        if (matrix[pos[0]][pos[1]+1] == '$') {
                            coins++;
                        }
                        pos[1]++;
                    }
                } catch (Exception e) {
                    walls++;
                }
                    break;
                case 'V': try {
                    if (matrix[pos[0]+1][pos[1]] == null) {
                        walls++;
                    } else {
                        if (matrix[pos[0]+1][pos[1]] == '$') {
                            coins++;
                        }
                        pos[0]++;
                    }
                } catch (Exception e) {
                    walls++;
                }
                    break;
                case '^': try {
                    if (matrix[pos[0]-1][pos[1]] == null) {
                        walls++;
                    } else {
                        if (matrix[pos[0]-1][pos[1]] == '$') {
                            coins++;
                        }
                        pos[0]--;
                    }
                } catch (Exception e) {
                    walls++;
                }
                    break;
                case '<': try {
                    if (matrix[pos[0]][pos[1]-1] == null) {
                        walls++;
                    } else {
                        if (matrix[pos[0]][pos[1]-1] == '$') {
                            coins++;
                        }
                        pos[1]--;
                    }
                } catch (Exception e) {
                    walls++;
                }
                    break;
            }
        }
        System.out.println("Coins = " + coins);
        System.out.println("Walls = " + walls);
    }
}
