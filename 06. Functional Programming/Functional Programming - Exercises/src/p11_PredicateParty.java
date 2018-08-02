import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class p11_PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> people = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        String[] commandLine = reader.readLine().split("\\s+");
        while(!"Party!".equals(commandLine[0])){
            String command = commandLine[0];
            String criteria = commandLine[1];
            String details = commandLine[2];
            BiPredicate<String, String> condition = null;
            switch (criteria){
                case "StartsWith":
                    condition = String::startsWith;
                    break;
                case "EndsWith":
                    condition = String::endsWith;
                    break;
                case "Length":
                    condition = (name, length) -> name.length()==Integer.parseInt(length);
                    break;
            }
            switch (command){
                case "Double":
                    doubleName(people, details, condition);
                    break;
                case "Remove":
                    removeName(people, details, condition);
                    break;
            }
            commandLine = reader.readLine().split(" ");
        }
        if (people.isEmpty()){
            System.out.println("Nobody is going to the party!");
        } else {
            StringBuilder sb = new StringBuilder();
            for (String person : people) {
                sb.append(person).append(", ");
            }
            sb.replace(sb.length()-2, sb.length()-1, " are going to the party!");
            System.out.println(sb);
        }
    }

    private static void removeName(List<String> people, String details, BiPredicate<String, String> condition) {
        for (int i = 0; i < people.size(); i++){
            if(condition.test(people.get(i), details)){
                people.remove(i);
                i--;
            }
        }
    }

    private static void doubleName(List<String> people, String details, BiPredicate<String, String> condition) {
        for (int i = 0; i < people.size(); i++){
            if(condition.test(people.get(i), details)){
                people.add(i+1, people.get(i));
                i++;
            }
        }
    }
}
