import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class p15_ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> usernames = Arrays.stream(reader.readLine().split("[ \\/\\\\()]+")).collect(Collectors.toList());
        Pattern pattern = Pattern.compile("^[A-Za-z][A-Za-z0-9_]{2,24}$");
        for (int i = usernames.size() - 1; i >= 0; i--) {
            Matcher matcher = pattern.matcher(usernames.get(i));
            if (!matcher.find()) {
                usernames.remove(i);
            }
        }
        int biggestSum = 0;
        int firstIndex = 0;
        for (int i = 0; i < usernames.size()-1; i++){
            int currentSum = usernames.get(i).length() + usernames.get(i+1).length();
            if (currentSum>biggestSum){
                biggestSum = currentSum;
                firstIndex = i;
            }
        }
        System.out.println(usernames.get(firstIndex));
        System.out.println(usernames.get(firstIndex+1));
    }
}
