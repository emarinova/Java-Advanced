import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p04_Ranking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> allContests = new HashMap<>();
        List<Candidate> allCandidates = new ArrayList<>();
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
            if (allContests.containsKey(contest) && allContests.get(contest).equals(password)) {
                String candidateName = tokens[2];
                Long points = Long.parseLong(tokens[3]);
                boolean isThereSuchCandidate = false;
                for (Candidate candidate : allCandidates) {
                    if (candidate.getName().equals(candidateName)) {
                        if (candidate.getContests().containsKey(contest)) {
                            if (candidate.getContests().get(contest) < points) {
                                candidate.getContests().put(contest, points);
                                candidate.setPoints(candidate.getPoints() + points);
                            }
                        } else {
                            candidate.getContests().put(contest, points);
                            candidate.setPoints(candidate.getPoints() + points);
                        }
                        isThereSuchCandidate = true;
                        break;
                    }
                }
                if (!isThereSuchCandidate) {
                    Candidate temp = new Candidate(candidateName, points);
                    temp.getContests().put(contest, points);
                    allCandidates.add(temp);
                }
            }
            line = reader.readLine();
        }
        Candidate bestCandidate = allCandidates.get(0);
        for (Candidate candidate : allCandidates) {
            if (candidate.getPoints() > bestCandidate.getPoints()){
                bestCandidate = candidate;
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%nRanking: %n", bestCandidate.getName(), bestCandidate.getPoints());
        allCandidates.stream().sorted((c1, c2) -> c1.getName().compareTo(c2.getName())).forEach(candidate -> {
            System.out.println(candidate.getName());
            candidate.getContests().entrySet().stream().sorted((con1, con2) -> con2.getValue().compareTo(con1.getValue()))
                    .forEach(contest ->
                            System.out.printf("#  %s -> %d%n", contest.getKey(), contest.getValue()));
        });

    }
}

class Candidate {
    private String name;
    private Long points;
    private Map<String, Long> contests;

    public Candidate(String name, Long points) {
        this.name = name;
        this.points = points;
        this.contests = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public Map<String, Long> getContests() {
        return contests;
    }

    public void setContests(Map<String, Long> contests) {
        this.contests = contests;
    }
}
