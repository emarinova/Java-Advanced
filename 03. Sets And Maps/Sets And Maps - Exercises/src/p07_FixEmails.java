import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class p07_FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> emails = new LinkedHashMap<>();
        String input = reader.readLine();
        while(!"stop".equals(input)){
            String email = reader.readLine();
            if (email.toLowerCase().endsWith(".us") ||
                    email.toLowerCase().endsWith(".uk") ||
                    email.toLowerCase().endsWith(".com")) {
                input = reader.readLine();
            } else {
                emails.put(input, email);
                input = reader.readLine();
            }

        }
        for (Map.Entry<String, String> user : emails.entrySet()) {
            System.out.printf("%s -> %s%n", user.getKey(), user.getValue());
        }
    }
}
