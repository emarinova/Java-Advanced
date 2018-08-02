import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class p02_SetsOfElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] n = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();
        Set<String> repeatingSet = new LinkedHashSet<>();
        for (int i = 0; i < n[0]; i++){
            String element = reader.readLine();
            firstSet.add(element);
        }
        for (int i = 0; i < n[1]; i++){
            String element = reader.readLine();
            secondSet.add(element);
        }
        for (String element : firstSet) {
            if (secondSet.contains(element)){
                repeatingSet.add(element);
            }
        }
        for (String element : repeatingSet){
            System.out.print(element + " ");
        }
    }
}
