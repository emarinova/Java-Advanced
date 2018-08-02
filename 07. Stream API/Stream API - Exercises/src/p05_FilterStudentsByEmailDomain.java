import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class p05_FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> students = new LinkedHashMap<>();
        String[] studentData = reader.readLine().split(" ");
        while(!"END".equals(studentData[0])){
            students.put(studentData[0] + " " + studentData[1], studentData[2]);
            studentData = reader.readLine().split(" ");
        }
        students.entrySet().stream()
                .filter(x -> x.getValue().endsWith("@gmail.com"))
                .forEach(x -> System.out.println(x.getKey()));
    }
}
