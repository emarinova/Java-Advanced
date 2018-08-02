import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p16_ExtractHyperlinks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("href\\s*=\\s*(\\\"|'?)(.*?)\\1[\\s>]");
        StringBuilder sb = new StringBuilder();
        String line;
        while(true){
            if("END".equals(line = reader.readLine())){
                break;
            }
            sb.append(line).append(System.lineSeparator());
        }
        String text = sb.toString();

        int startIndex = 0;
        startIndex = text.indexOf("<", startIndex);
        while(startIndex>=0){
            int endIndex = text.indexOf(">", startIndex+1);
            String subText = text.substring(startIndex+1, endIndex+1);
            if (subText.startsWith("!--")){
                startIndex = text.indexOf("<", startIndex+1);
                subText = text.substring(startIndex+1, endIndex+1);
            }
            if (subText.charAt(0)=='a') {
                Matcher matcher = pattern.matcher(subText);
                while (matcher.find()) {
                    System.out.println(matcher.group(2));
                }
            }
            startIndex = text.indexOf("<", endIndex+1);
        }
    }
}
