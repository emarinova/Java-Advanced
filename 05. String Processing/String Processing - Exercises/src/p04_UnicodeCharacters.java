import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class p04_UnicodeCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        for(int i = 0; i < text.length(); i++){
            System.out.printf("\\u00%s", Integer.toHexString((int) text.charAt(i)));
        }
    }
}
