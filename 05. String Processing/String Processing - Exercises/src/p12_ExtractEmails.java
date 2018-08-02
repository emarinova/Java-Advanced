import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class p12_ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("(^|\\s+)([a-z]+[\\w-.]*[a-z]@[a-z]+[\\w-.]*[a-z]+\\.[a-z]+[\\w-]*[a-z]+)(\\W|$)");
        String input = reader.readLine();
        while(!"end".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                System.out.println(matcher.group(2));
            }
            input = reader.readLine();
        }
    }
}
