import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p08_FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Function<List<Integer>, Integer> smallestElement = elements -> {
            int smallest = 0;
            for(int i = 1; i < elements.size(); i++){
                if (elements.get(i)<=elements.get(smallest)){
                    smallest = i;
                }
            }
            return smallest;
        };
        System.out.println(smallestElement.apply(numbers));
    }
}
