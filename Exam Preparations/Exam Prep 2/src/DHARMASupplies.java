import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DHARMASupplies {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputLines = new ArrayList<>();
        String line = reader.readLine();
        while(!"Collect".equals(line)){
            inputLines.add(line);
            line = reader.readLine();
        }
        Pattern pattern = Pattern.compile("\\[(#?(([a-z]*)|([0-9]*)))([A-Za-z0-9\\s]*)\\1]");
        List<Pair<String, String>> matches = new ArrayList<>();
        for (String inputLine : inputLines) {
            Matcher matcher = pattern.matcher(inputLine);
            while(matcher.find()){
                matches.add(new Pair<>(matcher.group(1),matcher.group(5)));
            }
        }
        Integer N = matches.size() / inputLines.size();
        Integer food = 0;
        Integer drinks = 0;
        for (int i = 0; i < matches.size(); i++){
            if (matches.get(i).getKey().startsWith("#") && matches.get(i).getKey().length() == N+1 && matches.get(i).getValue().length()>0){
                Set<Character> characters = new HashSet<>();
                for (int j = 0; j < matches.get(i).getValue().length(); j++){
                    characters.add(matches.get(i).getValue().charAt(j));
                }
                if (Character.isDigit(matches.get(i).getKey().charAt(1))){
                    Integer temp = 0;
                    for (Character character : characters) {
                        temp += (int)character;
                    }
                    temp *= N;
                    food += temp;
                } else {
                    Integer temp = 0;
                    for (int p = 0; p < matches.get(i).getValue().length(); p++){
                        temp += matches.get(i).getValue().charAt(p);
                    }

                    Integer temp2 = 0;
                    for (int k = 1; k < matches.get(i).getKey().length(); k++){
                        temp2 += matches.get(i).getKey().charAt(k);
                    }
                    temp *= temp2;
                    drinks += temp;
                }
            } else {
                matches.remove(i);
                i--;
            }
        }
        if (matches.size()==0){
            System.out.println("No supplies found!");
        } else {
            System.out.printf("Number of supply crates: %d%n" +
                    "Amount of food collected: %d%n" +
                    "Amount of drinks collected: %d", matches.size(), food, drinks);
        }
    }
}
