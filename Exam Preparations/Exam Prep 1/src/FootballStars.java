import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FootballStars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Match> matches = new ArrayList<>();
        String input = reader.readLine();
        while(!"Season End".equals(input)){
            String[] data = input.split(" ");
            String team1 = data[0];
            String team2 = data[2];
            String result = data[4];
            matches.add(new Match(team1, team2, result));
            input = reader.readLine();
        }
        String[] teamsToShow = reader.readLine().split(",\\s");
        for (int i = 0; i < teamsToShow.length; i++){
            String team = teamsToShow[i];
            matches.stream().filter(match -> match.getFirstTeam().equals(team) || match.getSecondTeam().equals(team))
                    .sorted((match, secondMatch) -> {
                        String otherTeam = match.getFirstTeam().equals(team) ? match.getSecondTeam() : match.getFirstTeam();
                        String secondOtherTeam = secondMatch.getFirstTeam().equals(team) ? secondMatch.getSecondTeam() : secondMatch.getFirstTeam();
                        return otherTeam.compareTo(secondOtherTeam);
                    })
                    .forEach(match -> {
                        if (match.getFirstTeam().equals(team)){
                            System.out.printf("%s - %s -> %s%n", match.getFirstTeam(), match.getSecondTeam(), match.getResult());
                        } else {
                            StringBuilder sb = new StringBuilder(match.getResult());
                            System.out.printf("%s - %s -> %s%n", match.getSecondTeam(), match.getFirstTeam(), sb.reverse());
                        }
                    });
        }

    }
}

class Match {
    private String firstTeam;
    private String secondTeam;
    private String result;

    public Match(String firstTeam, String secondTeam, String result) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.result = result;
    }

    public String getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(String firstTeam) {
        this.firstTeam = firstTeam;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(String secondTeam) {
        this.secondTeam = secondTeam;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
