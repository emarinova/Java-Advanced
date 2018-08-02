import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class p03_PeriodicTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Set<String> elements = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            for (int j = 0; j < tokens.length; j++){
                elements.add(tokens[j]);
            }
        }
        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
