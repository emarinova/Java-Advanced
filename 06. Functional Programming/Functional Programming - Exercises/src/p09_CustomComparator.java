import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class p09_CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = reader.readLine().split(" ");
        Integer[] numbers = new Integer[array.length];
        for(int i = 0; i < array.length; i++){
            numbers[i] = Integer.parseInt(array[i]);
        }
        Comparator<Integer> comparator = (x, y) -> {
            if (x%2==0){
                if (y%2==0){
                    return x-y;
                } else {
                    return -1;
                }
            } else {
                if (y%2==0){
                    return 1;
                } else {
                    return x-y;
                }
            }
        };

        Arrays.sort(numbers, comparator);
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
