import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class p13_SentanceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        Pattern pattern = Pattern.compile("([A-Z][^.!?]*\\s+" + word + "\\s+.*?[?!.])");
        Matcher matcher = pattern.matcher(reader.readLine());
        while(matcher.find()){
            System.out.println(matcher.group(1));
        }
    }
}
