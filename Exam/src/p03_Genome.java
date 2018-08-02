import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p03_Genome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> genome = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("([a-z!@#$?]+)=(\\d+)--(\\d+)<<([a-z]+)");
        String line = reader.readLine();
        while(!"Stop!".equals(line)){
            Matcher matcher = pattern.matcher(line);
            while(matcher.find()){
                String genomeName = matcher.group(1);
                Integer length = Integer.parseInt(matcher.group(2));
                Integer genes = Integer.parseInt(matcher.group(3));
                String organism = matcher.group(4);
                Integer countLength = 0;
                for (int i = 0; i < genomeName.length(); i++){
                    if ((int)genomeName.charAt(i) > 96 && (int)genomeName.charAt(i) < 123){
                        countLength++;
                    }
                }
                if (countLength==length){
                    if (!genome.containsKey(organism)) {
                        genome.put(organism, 0);
                    }
                    genome.put(organism, genome.get(organism) + genes);
                }
            }
            line = reader.readLine();
        }
        genome.entrySet().stream().sorted((g1, g2) -> g2.getValue().compareTo(g1.getValue()))
                .forEach(g -> System.out.printf("%s has genome size of %d%n", g.getKey(), g.getValue()));
    }
}
