import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p14_SumOfAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String keyStrings = reader.readLine();
        Pattern keyPattern = Pattern.compile("^([A-Za-z_]+)((\\d.*\\d)|(\\d))([A-Za-z_]+)$");
        Matcher keyMatcher = keyPattern.matcher(keyStrings);
        if (!keyMatcher.find()){
            System.out.println("<p>A key is missing</p>");
        } else {
            String startKey = keyMatcher.group(1);
            String endKey = keyMatcher.group(5);

            String text = reader.readLine();
            Pattern textPattern = Pattern.compile(startKey + "(\\d*(\\.\\d+)?)" + endKey);
            Matcher textMatcher = textPattern.matcher(text);

            double sum = 0.0;
            while (textMatcher.find()) {
                try {
                    double number = Double.parseDouble(textMatcher.group(1));
                    sum += number;
                } catch (Exception ignored) {

                }
            }
            DecimalFormat df = new DecimalFormat("0.##");
            if (sum == 0.0) {
                System.out.println("<p>The total value is: <em>nothing</em></p>");
            } else {
                System.out.printf("<p>The total value is: <em>%s</em></p>", df.format(sum));
            }
        }
    }
}