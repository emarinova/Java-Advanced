import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<VLogger> vLoggers = new ArrayList<>();
        Set<String> vLoggersNames = new HashSet<>();
        String input = reader.readLine();
        while(!"Statistics".equals(input)){
            String[] tokens = input.split("\\s+");
            if (tokens.length==4){
                String vLoggerName = tokens[0];
                if(!vLoggersNames.contains(vLoggerName)){
                    vLoggersNames.add(vLoggerName);
                    vLoggers.add(new VLogger(vLoggerName));
                }
            } else if (tokens.length==3){
                String vLoggerFollowing = tokens[0];
                String vLoggerFollowed = tokens[2];
                if (vLoggersNames.contains(vLoggerFollowing) && vLoggersNames.contains(vLoggerFollowed) && !vLoggerFollowed.equals(vLoggerFollowing)){
                    VLogger following = null;
                    VLogger followed = null;
                    for (VLogger vLogger : vLoggers) {
                        if (vLogger.getName().equals(vLoggerFollowing)){
                            following = vLogger;
                        }
                        if (vLogger.getName().equals(vLoggerFollowed)){
                            followed = vLogger;
                        }
                    }
                    followed.getFollowers().add(vLoggerFollowing);
                    following.getFollowing().add(vLoggerFollowed);
                }
            }
            input = reader.readLine();
        }
        System.out.printf("The V-Logger has a total of %d vloggers in its logs.%n", vLoggers.size());
        Comparator<VLogger> compareFollowers = Comparator.comparing(vL -> vL.getFollowers().size());
        Comparator<VLogger> compareFollowing = Comparator.comparing(vL -> vL.getFollowing().size());
        vLoggers = vLoggers.stream().sorted(compareFollowers.reversed().thenComparing(compareFollowing)).collect(Collectors.toList());
        VLogger mostFollowed = vLoggers.get(0);
        System.out.printf("1. %s : %d followers, %d following%n", mostFollowed.getName(), mostFollowed.getFollowers().size(), mostFollowed.getFollowing().size());
        for(String follower : mostFollowed.getFollowers()){
            System.out.printf("* %s%n", follower);
        }
        for(int i = 1 ; i < vLoggers.size(); i++){
            System.out.printf("%d. %s : %d followers, %d following%n", i+1, vLoggers.get(i).getName(), vLoggers.get(i).getFollowers().size(), vLoggers.get(i).getFollowing().size());
        }
    }
}

class VLogger {
    private String name;
    private Set<String> followers;
    private Set<String> following;

    public VLogger(String name) {
        this.name = name;
        this.followers = new TreeSet<>();
        this.following = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<String> followers) {
        this.followers = followers;
    }

    public Set<String> getFollowing() {
        return following;
    }

    public void setFollowing(Set<String> following) {
        this.following = following;
    }
}
