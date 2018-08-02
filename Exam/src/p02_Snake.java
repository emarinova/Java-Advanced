
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02_Snake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[][] screen = new String[n][n];
        int x = 0;
        int y = 0;
        String[] commands = reader.readLine().split(", ");
        Integer food = 0;
        for (int i = 0; i < screen.length; i++){
            screen[i] = reader.readLine().split("\\s+");
            for (int j = 0; j < screen[i].length; j++){
                if (screen[i][j].charAt(0) == 'f'){
                    food++;
                } else if (screen[i][j].charAt(0) == 's'){
                    x = i;
                    y = j;
                }
            }
        }


        Integer snakeLength = 1;
        boolean lost = false;

        for (String command : commands) {
            switch (command){
                case "up":
                    x--;
                    if (x < 0) {
                        x = n-1;
                    }
                    break;
                case "down":
                    x++;
                    if (x > n-1) {
                        x = 0;
                    }
                    break;
                case "right":
                    y++;
                    if (y > n-1) {
                        y = 0;
                    }
                    break;
                case "left":
                    y--;
                    if (y < 0) {
                        y = n-1;
                    }
                    break;
            }

            if (screen[x][y].charAt(0) == 'e'){
                lost = true;
                break;
            } else if (screen[x][y].charAt(0) == 'f'){
                food--;
                snakeLength++;
                screen[x][y] = "*";
                if (food==0){
                    break;
                }
            }

        }
        if(lost){
            System.out.println("You lose! Killed by an enemy!");
        } else if (food<1){
            System.out.printf("You win! Final snake length is %d", snakeLength);
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.", food);
        }
    }

}
