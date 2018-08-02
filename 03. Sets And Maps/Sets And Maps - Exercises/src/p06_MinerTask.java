import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class p06_MinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> resources = new LinkedHashMap<>();
        String input = reader.readLine();
        while (!"stop".equals(input)){
            Integer quantity = Integer.parseInt(reader.readLine());
            if (!resources.containsKey(input)) {
                resources.put(input, 0);
            }
            resources.put(input, resources.get(input) + quantity);
            input = reader.readLine();
        }
        for (Map.Entry<String, Integer> resource : resources.entrySet()) {
            System.out.printf("%s -> %d%n", resource.getKey(), resource.getValue());
        }
    }
}
