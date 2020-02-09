import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Students {

    static class Student {

        String firstName;
        String secondName;
        double grade;

        Student(String firstName, String secondName, double grade) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return String.format("%s %s: %.2f",this.firstName,this.secondName,this.grade);
        }

        public double getGrade() {
            return this.grade;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");

            String firstName = tokens[0];
            String secondName = tokens[1];
            double grade = Double.parseDouble(tokens[2]);

            Student student = new Student(firstName, secondName, grade);
            students.add(student);
        }

        students.sort(Comparator.comparingDouble(Student::getGrade).reversed());

        for (Student student : students) {
            System.out.println(student.toString());
        }


    }

}
