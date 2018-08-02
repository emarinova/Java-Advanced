import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class p09_StudentsByEnrollmentYear {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> students = new LinkedHashMap<>();
        String[] studentData = reader.readLine().split(" ");
        while(!"END".equals(studentData[0])){
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < studentData.length; i++){
                sb.append(studentData[i]).append(" ");
            }
            students.put(studentData[0], sb.toString());
            studentData = reader.readLine().split(" ");
        }
        students.entrySet().stream()
                .filter(x -> x.getKey().endsWith("14") || x.getKey().endsWith("15"))
                .forEach(x -> System.out.println(x.getValue()));
    }
}
