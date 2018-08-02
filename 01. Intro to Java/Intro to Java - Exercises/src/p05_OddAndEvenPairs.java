import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p05_OddAndEvenPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if(input.length%2==1) System.out.println("invalid length");
        else {
            for (int i = 0; i < input.length-1; i+=2){
                if(Math.abs(input[i]%2 - input[i+1]%2) == 1){
                    System.out.printf("%d, %d -> different%n", input[i], input[i+1]);
                } else if(input[i]%2==0) {
                    System.out.printf("%d, %d -> both are even%n", input[i], input[i+1]);
                } else {
                    System.out.printf("%d, %d -> both are odd%n", input[i], input[i+1]);
                }
            }
        }
    }
}
