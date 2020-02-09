import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll {

    static class People {

        String firstName;
        int age;

        People(String firstName, int age) {
            this.firstName = firstName;
            this.age = age;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public int getAge() {
            return this.age;
        }

        @Override
        public String toString() {
            return String.format("%s - %d", this.firstName, this.age);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<People> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");

            String firstName = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            People people1 = new People(firstName, age);
            people.add(people1);

        }

        people.sort((f, s) -> f.getFirstName().compareTo(s.getFirstName()));

        for (People person : people) {
            if (person.getAge() > 30){
                System.out.println(person);
            }
        }


    }
}
