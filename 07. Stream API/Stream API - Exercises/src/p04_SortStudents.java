import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class p04_SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String[]> students = new HashSet<>();
        String[] studentData = reader.readLine().split(" ");
        while(!"END".equals(studentData[0])){
            students.add(studentData);
            studentData = reader.readLine().split(" ");
        }
        Comparator<String[]> comparatorLastNames = Comparator.comparing(x -> x[1]);
        Comparator<String[]> comparatorFirstNames = Comparator.comparing(x -> x[0]);

        students.stream().sorted(comparatorLastNames.thenComparing(comparatorFirstNames.reversed()))
                .forEach(x -> System.out.println(x[0] + " " + x[1]));
    }
}
