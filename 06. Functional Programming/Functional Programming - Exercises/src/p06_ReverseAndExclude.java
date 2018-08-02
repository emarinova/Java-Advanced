import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class p06_ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Integer number = Integer.parseInt(reader.readLine());
        BiPredicate<Integer, Integer> isDivisible = (x, y) -> x%y==0;
        for(int i = numbers.size()-1; i>=0; i--){
            if(isDivisible.test(numbers.get(i), number)) {
                numbers.remove(i);
            }
        }
        Consumer<List<Integer>> reverseAndPrint = arr -> {
            StringBuilder sb = new StringBuilder();
            for(int i = arr.size()-1; i >= 0; i--){
                sb.append(arr.get(i)).append(" ");
            }
            System.out.println(sb);
        };

        reverseAndPrint.accept(numbers);
    }
}
