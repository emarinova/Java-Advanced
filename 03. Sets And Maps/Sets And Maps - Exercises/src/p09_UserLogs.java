import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class p09_UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();
        String[] input = reader.readLine().split(" ");
        while (!"end".equals(input[0])){
            String[] ipData = input[0].split("=");
            String ip = ipData[1];
            String[] userData = input[2].split("=");
            String user = userData[1];
            if(!users.containsKey(user)){
                users.put(user, new LinkedHashMap<>());
            }
            if(!users.get(user).containsKey(ip)){
                users.get(user).put(ip, 0);
            }
            users.get(user).put(ip, users.get(user).get(ip) + 1);
            input = reader.readLine().split(" ");
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : users.entrySet()) {
            sb.append(String.format("%s:%n", user.getKey()));
            for (Map.Entry<String, Integer> ip : user.getValue().entrySet()) {
                sb.append(String.format("%s => %d, ", ip.getKey(), ip.getValue()));
            }
            sb.replace(sb.length()-2, sb.length()-1, ".");
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
