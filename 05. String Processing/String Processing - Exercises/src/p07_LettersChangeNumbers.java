import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class p07_LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\s+");
        Double sum = 0.0;
        for (String token : tokens) {
            String letterBefore = token.charAt(0)+ "";
            String letterAfter = token.charAt(token.length()-1)+ "";
            Double number = Double.parseDouble(token.substring(1, token.length()-1));
            if(letterBefore.equals(letterBefore.toLowerCase())){
                number *= letterBefore.charAt(0) - 96;
            } else {
                number /= letterBefore.charAt(0) - 64;
            }
            if(letterAfter.equals(letterAfter.toLowerCase())){
                number += letterAfter.charAt(0) - 96;
            } else {
                number -= letterAfter.charAt(0) - 64;
            }
            sum += number;
        }
        System.out.printf("%.2f", sum);
    }
}
