package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Animal> animal = new ArrayList<>();

        while (!input.equals("Beast!")) {

            String[] tokens = scanner.nextLine().split(" ");

            Animal animals;
            try {
                if (input.equals("Dog")) {
                    animals = new Dog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                } else if (input.equals("Cat")) {
                    animals = new Cat(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                } else if (input.equals("Frog")) {
                    animals = new Frog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                } else if (input.equals("Kittens")) {
                    animals = new Kitten(tokens[0], Integer.parseInt(tokens[1]));
                } else {
                    animals = new Tomcat(tokens[0], Integer.parseInt(tokens[1]));
                }

                animal.add(animals);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            input = scanner.nextLine();
        }

        for (Animal animals : animal) {
            System.out.println(animals.toString());
        }

    }
}
