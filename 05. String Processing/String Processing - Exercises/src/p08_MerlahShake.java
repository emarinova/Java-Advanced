import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p08_MerlahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        String pattern = reader.readLine();
        StringBuilder sbText = new StringBuilder(text);
        StringBuilder sbPattern = new StringBuilder(pattern);
        boolean shaked = true;

        while (shaked) {
            if (sbPattern.length()==0){
                shaked=false;
                System.out.println("No shake.");
                break;
            }
            int firstIndex = sbText.indexOf(sbPattern.toString());
            int lastIndex = sbText.lastIndexOf(sbPattern.toString());
            if (firstIndex != lastIndex && firstIndex != -1) {
                sbText.replace(lastIndex, lastIndex + sbPattern.length(), "");
                sbText.replace(firstIndex, firstIndex + sbPattern.length(), "");
                sbPattern.replace(sbPattern.length() / 2, sbPattern.length() / 2 + 1, "");
                System.out.println("Shaked it.");
            } else {
                shaked = false;
                System.out.println("No shake.");
            }
        }
        System.out.println(sbText);
    }
}
