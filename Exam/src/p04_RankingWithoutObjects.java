import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class p04_RankingWithoutObjects {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> allContests = new HashMap<>();
        Map<String, Map<String, Integer>> allCandidates = new TreeMap<>();
        String line = reader.readLine();
        while(!"end of contests".equals(line)){
            String[] tokens = line.split(":");
            String contest = tokens[0];
            String password = tokens[1];
            allContests.put(contest, password);
            line = reader.readLine();
        }
        line = reader.readLine();
        while(!"end of submissions".equals(line)){
            String[] tokens = line.split("=>");
            String contest = tokens[0];
            String password = tokens[1];
            if(allContests.containsKey(contest) && allContests.get(contest).equals(password)){
                String candidateName = tokens[2];
                Integer points = Integer.parseInt(tokens[3]);
                if (!allCandidates.containsKey(candidateName)){
                    allCandidates.put(candidateName, new LinkedHashMap<>());
                }
                if (!allCandidates.get(candidateName).containsKey(contest)){
                    allCandidates.get(candidateName).put(contest, 0);
                }
                if (allCandidates.get(candidateName).get(contest) < points) {
                    allCandidates.get(candidateName).put(contest, points);
                }
            }
            line = reader.readLine();
        }

        allCandidates.entrySet().stream().sorted((c1, c2) -> {
            return ((Integer) c2.getValue().entrySet().stream().mapToInt(Map.Entry::getValue).sum())
                    .compareTo(c1.getValue().entrySet().stream().mapToInt(Map.Entry::getValue).sum());
        }).limit(1).forEach(c -> System.out.printf("Best candidate is %s with total %d points.%n" +
                "Ranking: %n", c.getKey(), c.getValue().entrySet().stream().mapToInt(Map.Entry::getValue).sum()));

        allCandidates.entrySet().stream().forEach(c ->{
            System.out.println(c.getKey());
            c.getValue().entrySet().stream().sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                    .forEach(contest -> System.out.printf("#  %s -> %d%n", contest.getKey(), contest.getValue()));
        });
    }
}
