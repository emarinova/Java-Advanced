import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class p04_CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Map<Character, Integer> occurances = new TreeMap<>();
        for (int i = 0; i < input.length(); i++){
            if (!occurances.containsKey(input.charAt(i))) {
                occurances.put(input.charAt(i), 0);
            }
            occurances.put(input.charAt(i), occurances.get(input.charAt(i)) + 1);
        }
        for (Map.Entry<Character, Integer> letter : occurances.entrySet()) {
            System.out.printf("%s: %d time/s%n", letter.getKey(), letter.getValue());
        }
    }
}
