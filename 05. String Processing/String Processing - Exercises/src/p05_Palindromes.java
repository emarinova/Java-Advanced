import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class p05_Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> palindromes = new TreeSet<>();
        String[] words = reader.readLine().split("[ ,.?!]");
        for (String word : words) {
            if(word.equals(new StringBuilder(word).reverse().toString())){
                palindromes.add(word);
            }
        }
        System.out.println(palindromes);
    }
}
