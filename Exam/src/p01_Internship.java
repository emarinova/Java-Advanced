import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p01_Internship {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer problemsCount = Integer.parseInt(reader.readLine());
        Integer candidatesCount = Integer.parseInt(reader.readLine());
        ArrayDeque<String> problems = new ArrayDeque<>();
        ArrayDeque<String> candidates = new ArrayDeque<>();
        Pattern namePattern = Pattern.compile("^[A-Z][a-z]+\\s+[A-Z][a-z]+$");
        for (int i = 0; i < problemsCount; i++) {
            problems.push(reader.readLine());
        }
        for (int i = 0; i < candidatesCount; i++) {
            String candidate = reader.readLine();
            Matcher matcher = namePattern.matcher(candidate);
            if (matcher.find()) {
                candidates.offer(candidate);
            }
        }
        if (!candidates.isEmpty()) {
            while (candidates.size() > 1 && !problems.isEmpty()) {
                String problem = problems.poll();
                String candidate = candidates.poll();
                if (asciiSum(problem) < asciiSum(candidate)) {
                    System.out.printf("%s solved %s.%n", candidate, problem);
                    candidates.offer(candidate);
                } else {
                    System.out.printf("%s failed %s.%n", candidate, problem);
                    problems.offer(problem);
                }
            }
            if (!candidates.isEmpty() && candidates.size() == 1) {
                System.out.printf("%s gets the job!", candidates.poll());
            } else {
                StringBuilder sb = new StringBuilder();
                while (!candidates.isEmpty()) {
                    sb.append(candidates.poll()).append(", ");
                }
                sb.delete(sb.length() - 2, sb.length());
                System.out.println(sb);
            }
        }
    }

    public static Integer asciiSum(String string){
        Integer sum = 0;
        for (int i = 0; i < string.length(); i++){
            sum += (int)string.charAt(i);
        }
        return sum;
    }
}
