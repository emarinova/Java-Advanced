import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class p01_UniqueUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Set<String> usernames = new LinkedHashSet<>();
        for (int i = 0; i < n; i++){
            String username = reader.readLine();
            usernames.add(username);
        }
        for (String username : usernames){
            System.out.println(username);
        }
    }
}
