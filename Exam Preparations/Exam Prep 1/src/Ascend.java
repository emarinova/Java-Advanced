import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascend {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> patterns = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("[,_][A-Za-z]+[0-9]");

        String line = reader.readLine();

        while(!"Ascend".equals(line)){

            for (String pat : patterns.keySet()) {
                if (line.contains(pat)) {
                    line = line.replace(pat, patterns.get(pat));
                }
            }

            Matcher matcher = pattern.matcher(line);

            while (matcher.find()){
                String encodedMsg = matcher.group(0);
                Integer digit = encodedMsg.charAt(encodedMsg.length()-1) - '0';
                char symbol = encodedMsg.charAt(0);
                StringBuilder sb = new StringBuilder();
                if (symbol==',') {
                    for (int i = 1; i < encodedMsg.length() - 1; i++) {
                        sb.append((char)((int)encodedMsg.charAt(i) + digit));
                    }
                } else {
                    for (int i = 1; i < encodedMsg.length() - 1; i++) {
                        sb.append((char)((int)encodedMsg.charAt(i) - digit));
                    }
                }
                String decodedMsg = sb.toString();
                patterns.put(encodedMsg, decodedMsg);
                line = line.replace(matcher.group(0), decodedMsg);
            }

            System.out.println(line);
            line = reader.readLine();
        }
    }
}