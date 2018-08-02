import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p11_ReplaceATag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("(<a)\\s+href[^>]+(>)\\s*.*?(<\\/a>)");
        StringBuilder sb = new StringBuilder();
        String input = reader.readLine();
        while(!"END".equals(input)){
            sb.append(input).append(System.lineSeparator());
            input = reader.readLine();
        }
        String result = sb.toString();
        Matcher matcher = pattern.matcher(result);
        while (matcher.find()){
            String entireMatch = matcher.group(0);
            String openATag = matcher.group(1);
            String closeOpenATag = matcher.group(2);
            String closeTag = matcher.group(3);
            String replacement = entireMatch.replaceFirst(openATag, "[URL");
            replacement = replacement.replaceFirst(closeOpenATag, "]");
            replacement = replacement.replaceFirst(closeTag, "[/URL]");
            result = result.replace(entireMatch, replacement);

        }
        System.out.println(result);
    }
}
