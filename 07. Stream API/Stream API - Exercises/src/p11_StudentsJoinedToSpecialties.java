import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class p11_StudentsJoinedToSpecialties {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<StudentSpecialty> studentSpecialties = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        String input = reader.readLine();
        while(!"Students:".equals(input)){
            String[] data = input.split("\\s+");
            String facultyNumber = data[2];
            String specialtyName = data[0] + " " + data[1];
            studentSpecialties.add(new StudentSpecialty(specialtyName, facultyNumber));
            input = reader.readLine();
        }
        input = reader.readLine();
        while(!"END".equals(input)){
            String[] data = input.split("\\s+");
            String facultyNumber = data[0];
            String studentName = data[1] + " " + data[2];
            students.add(new Student(studentName, facultyNumber));
            input = reader.readLine();
        }
        students.stream().sorted(Comparator.comparing(Student::getName)).forEach(student -> {
            studentSpecialties.stream()
                    .filter(studentSpecialty -> studentSpecialty.getFacultyNumber().equals(student.getFacultyNumber()))
                    .forEach(studentSpecialty -> System.out.println(student.getName() + " " + student.getFacultyNumber() + " " + studentSpecialty.getName()));
        });
    }
}

class StudentSpecialty {
    private String name;
    private String facultyNumber;

    public StudentSpecialty(String name, String facultyNumber) {
        this.name = name;
        this.facultyNumber = facultyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}

class Student{
    private String name;
    private String facultyNumber;

    public Student(String name, String facultyNumber) {
        this.name = name;
        this.facultyNumber = facultyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}
