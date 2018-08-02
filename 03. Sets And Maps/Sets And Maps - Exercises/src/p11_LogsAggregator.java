import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class p11_LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> usersDuration = new TreeMap<>();
        Map<String, TreeSet<String>> usersIPs = new HashMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++){
            String[] input = reader.readLine().split(" ");
            String ip = input[0];
            String user = input[1];
            int duration = Integer.parseInt(input[2]);
            if (!usersDuration.containsKey(user)){
                usersDuration.put(user, 0);
                usersIPs.put(user, new TreeSet<>());
            }
            usersDuration.put(user, usersDuration.get(user) + duration);
            usersIPs.get(user).add(ip);
        }
        for (Map.Entry<String, Integer> userDuration : usersDuration.entrySet()) {
            System.out.printf("%s: %d ", userDuration.getKey(), userDuration.getValue());
            System.out.println(usersIPs.get(userDuration.getKey()));
        }
    }
}
