import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        String input = reader.readLine();
        String specialCharacters = "[].*+\\^|?(){}";
        while(!"Print".equals(input)){
            if(input.contains("%")){
                for(int i = 0; i < input.length(); i++){
                    if (specialCharacters.contains(input.charAt(i)+"")){
                        input = input.replace(input.charAt(i)+"", "\\" + input.charAt(i));
                        i++;
                    }
                }
                input = input.replace("%", "[^\\s]*");
                Pattern pattern = Pattern.compile(input);
                Matcher matcher = pattern.matcher(text);
                while(matcher.find()){
                    StringBuilder sb = new StringBuilder(matcher.group(0));
                    text = text.replace(matcher.group(0), sb.reverse().toString());
                }
            } else {
                StringBuilder sb = new StringBuilder(input);
                text = text.replace(input, sb.reverse());
            }
            input = reader.readLine();
        }
        System.out.println(text);
    }
}
