import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p12_ThePartyReservationFilterModel {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> people = new ArrayList<>();
        people = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        List<String> commands = new ArrayList<>();
        String input = reader.readLine();
        while(!"Print".equals(input)){
            commands.add(input);
            input = reader.readLine();
        }
        for (int i =0 ; i < commands.size(); i++){
            String[] commandTokens = commands.get(i).split(";");
            if ("Remove filter".equals(commandTokens[0])){
                for (int j = i-1; j >=0; j--){
                    String[] secondCommandTokens = commands.get(j).split(";");
                    if ("Add filter".equals(secondCommandTokens[0]) &&
                            secondCommandTokens[1].equals(commandTokens[1]) &&
                            secondCommandTokens[2].equals(commandTokens[2])){
                        commands.remove(i);
                        commands.remove(j);
                    }
                }
            }
        }
        for (String command : commands) {
            if (command.startsWith("Add filter")){
                String[] commandTokens = command.split(";");

                String filterType = commandTokens[1];
                String parameter = commandTokens[2];

                for (int i = 0; i < people.size(); i++) {
                    if(predicate(filterType, parameter).test(people.get(i))){
                        people.remove(i);
                    }
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        for (String person : people) {
            sb.append(person).append(" ");
        }
        System.out.println(sb);
    }

    private static Predicate<String> predicate(String filterType, String parameter){
        Predicate<String> predicate = null;
        switch (filterType){
            case "Starts with":
                predicate = x -> x.startsWith(parameter);
                break;
            case "Ends with":
                predicate = x -> x.endsWith(parameter);
                break;
            case "Length":
                predicate = x -> x.length()==Integer.parseInt(parameter);
                break;
            case "Contains":
                predicate = x -> x.contains(parameter);
                break;
        }
        return predicate;
    }
}
