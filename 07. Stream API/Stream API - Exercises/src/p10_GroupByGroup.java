import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class p10_GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] studentData = reader.readLine().split(" ");
        List<Person> students = new ArrayList<>();
        while(!"END".equals(studentData[0])){
            students.add(new Person(studentData[0] + " " + studentData[1], Integer.parseInt(studentData[2])));
            studentData = reader.readLine().split(" ");
        }
        Map<Integer, List<String>> groupedStudents = students.stream().collect(Collectors.groupingBy(Person::getGroup, Collectors.mapping(Person::getName, Collectors.toList())));
        groupedStudents.entrySet().stream().forEach(student -> {
            System.out.print(student.getKey() + " - ");
            StringBuilder sb = new StringBuilder();
            for (String name:student.getValue()){
                sb.append(name).append(", ");
            }
            sb.delete(sb.length()-2, sb.length());
            System.out.println(sb);
        });
    }
}

class Person {
    private String name;
    private Integer group;

    public Person(String name, Integer group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }
}
