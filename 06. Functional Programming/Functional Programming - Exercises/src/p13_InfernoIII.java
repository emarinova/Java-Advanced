import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p13_InfernoIII {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> gems = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Set<Integer> markedGems = new HashSet<>();
        List<String> commands = new ArrayList<>();
        String input = reader.readLine();
        while(!"Forge".equals(input)){
            commands.add(input);
            input = reader.readLine();
        }
        for (int i = 0; i < commands.size(); i++){
            if (commands.get(i).startsWith("Reverse")){
                for (int j = i-1; j >=0; j--){
                    if(commands.get(j).startsWith("Exclude") && commands.get(j).substring(7).equals(commands.get(i).substring(7))){
                        commands.remove(i);
                        commands.remove(j);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < commands.size(); i++){
            if(commands.get(i).startsWith("Exclude")){
                String[] commandTokens = commands.get(i).split(";");
                String filterType = commandTokens[1];
                Integer parameter = Integer.parseInt(commandTokens[2]);
                for(int j = 0; j < gems.size(); j++){
                    Integer left = j-1<0?0:gems.get(j-1);
                    Integer right = j+1>=gems.size()?0:gems.get(j+1);
                    if(predicate(filterType, parameter, left, right).test(gems.get(j))){
                        markedGems.add(gems.get(j));
                    }
                }

            }
        }
        gems.removeAll(markedGems);
        StringBuilder sb = new StringBuilder();
        for (Integer gem : gems) {
            sb.append(gem).append(" ");
        }
        System.out.println(sb);
    }
    private static Predicate<Integer> predicate(String filterType, Integer parameter, Integer left, Integer right){
        Predicate<Integer> predicate = null;
        switch (filterType){
            case "Sum Left":
                predicate = x -> x + left == parameter;
                break;
            case "Sum Right":
                predicate = x -> x + right == parameter;
                break;
            case "Sum Left Right":
                predicate = x -> x + left + right == parameter;
                break;
        }
        return predicate;
    }
}
