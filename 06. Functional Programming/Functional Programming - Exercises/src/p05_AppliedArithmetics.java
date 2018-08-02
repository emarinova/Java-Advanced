import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class p05_AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = reader.readLine();
        Function<int[], int[]> add = arr -> {
            for (int i = 0; i < arr.length; i++){
                arr[i]+=1;
            }
            return arr;
        };
        Function<int[], int[]> subtract = arr -> {
            for (int i = 0; i < arr.length; i++){
                arr[i]-=1;
            }
            return  arr;
        };
        Consumer<int[]> print = arr -> {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
        };
        while(!"end".equals(command)){
            switch (command){
                case "add":
                    add.apply(numbers);
                    break;
                case "subtract":
                    subtract.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    break;
            }
            command = reader.readLine();
        }
    }
}
