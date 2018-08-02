import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class p02_StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String[]> students = new LinkedHashSet<>();
        String[] studentData = reader.readLine().split(" ");
        while(!"END".equals(studentData[0])){
            students.add(studentData);
            studentData = reader.readLine().split(" ");
        }
        students.stream().filter(x -> x[0].compareTo(x[1]) < 0)
                .forEach(x -> System.out.println(x[0] + " " +x[1]));
    }
}
