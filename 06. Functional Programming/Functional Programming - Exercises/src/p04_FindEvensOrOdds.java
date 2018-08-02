import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class p04_FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] range = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String condition = reader.readLine();
        Predicate<Integer> isEven = x -> x%2==0;
        Predicate<Integer> isOdd = x -> x%2!=0;

        if (condition.equals("even")){
            printNumbers(isEven, range);
        } else {
            printNumbers(isOdd, range);
        }
    }

    private static void printNumbers(Predicate<Integer> condition, int[] range) {
        for (int i = range[0]; i <= range[1]; i++){
            if(condition.test(i)) System.out.print(i + " ");
        }
    }
}
