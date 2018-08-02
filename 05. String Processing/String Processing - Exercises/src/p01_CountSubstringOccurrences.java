import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_CountSubstringOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().toLowerCase();
        String toSearch = reader.readLine().toLowerCase();
        int counter = 0;
        while(input.indexOf(toSearch)>=0){
            counter++;
            input = input.replaceFirst(toSearch, "");
        }
        System.out.println(counter);
    }
}
