import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.LinkedHashMap;
        import java.util.Map;

public class p01_StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String[], Integer> students = new LinkedHashMap<>();
        String[] studentData = reader.readLine().split(" ");
        while(!"END".equals(studentData[0])){
            String[] studentFullName = new String[] {studentData[0], studentData[1]};
            Integer group = Integer.parseInt(studentData[2]);
            students.put(studentFullName, group);
            studentData = reader.readLine().split(" ");
        }
        students.entrySet().stream().filter(x -> x.getValue()==2)
                .sorted((x, y) -> x.getKey()[0].compareTo(y.getKey()[0]))
                .forEach(x -> System.out.println(x.getKey()[0] + " " + x.getKey()[1]));
    }
}
