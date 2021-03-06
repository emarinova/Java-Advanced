import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class p07_ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Integer>> students = new LinkedHashMap<>();
        String[] studentData = reader.readLine().split(" ");
        while(!"END".equals(studentData[0])){
            String fullName = studentData[0] + " " + studentData[1];
            students.put(fullName, new ArrayList<>());
            for(int i = 2; i < studentData.length; i++){
                students.get(fullName).add(Integer.parseInt(studentData[i]));
            }
            studentData = reader.readLine().split(" ");
        }
        students.entrySet().stream()
                .filter(x -> x.getValue().contains(6))
                .forEach(x -> System.out.println(x.getKey()));
    }
}
