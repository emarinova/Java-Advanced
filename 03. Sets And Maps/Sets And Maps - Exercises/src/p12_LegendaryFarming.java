import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p12_LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> possibleItems = new HashMap<>();
        possibleItems.put("fragments", 0);
        possibleItems.put("motes", 0);
        possibleItems.put("shards", 0);
        Map<String, Integer> junk = new HashMap<>();
        String obtained = "";
        while(true){
            String[] tokens = reader.readLine().split(" ");
            for (int i = 0; i < tokens.length-1; i+=2){
                String element = tokens[i+1].toLowerCase();
                Integer quantity = Integer.parseInt(tokens[i]);
                if (possibleItems.containsKey(element)){
                    possibleItems.put(element, possibleItems.get(element) + quantity);
                    if (possibleItems.get(element)>=250) {
                        obtained = element.equals("shards")?"Shadowmourne":(element.equals("fragments")?"Valanyr":"Dragonwrath");
                        possibleItems.put(element, possibleItems.get(element) - 250);
                        break;
                    }
                } else {
                    if (!junk.containsKey(element)) {
                        junk.put(element, 0);
                    }
                    junk.put(element, junk.get(element) + quantity);
                }
            }
            if(!"".equals(obtained)){
                break;
            }
        }

        System.out.println(obtained + " obtained!");
        Map<String, Integer> sortedItems = possibleItems.entrySet().stream().sorted((a, b) -> {
            return a.getKey().compareTo(b.getKey());
        }).sorted((a, b) -> {
            return b.getValue().compareTo(a.getValue());
        })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        Map<String, Integer> sortedJunk = junk.entrySet().stream().sorted(Comparator.comparing(j -> j.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        for (Map.Entry<String, Integer> item : sortedItems.entrySet()) {
            System.out.printf("%s: %d%n", item.getKey(), item.getValue());
        }
        for (Map.Entry<String, Integer> junkItem : sortedJunk.entrySet()) {
            System.out.printf("%s: %d%n", junkItem.getKey(), junkItem.getValue());
        }
    }
}
