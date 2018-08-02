import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class p10_ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer border = Integer.valueOf(reader.readLine());
        List<Integer> numsToDivideBy = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        BiPredicate<Integer, List<Integer>> isDivisible = (x, nums) -> {
            boolean divisible = true;
            for (Integer num : nums) {
                if (x%num!=0){
                    divisible = false;
                    break;
                }
            }
            return divisible;
        };
        for (int i = 1; i <= border; i++){
            if(isDivisible.test(i, numsToDivideBy)){
                System.out.print(i + " ");
            }
        }
    }
}
