package interfaceImplementation;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        List<Citizen> citizens = new ArrayList<>();
        List<Rebel> rebels = new ArrayList<>();


        for (int i = 0; i < number; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            if (tokens.length == 4) {
                Citizen citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
                citizens.add(citizen);
            } else {
                Rebel rebel = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                rebels.add(rebel);
            }
        }
        String names = scanner.nextLine();
        while (!names.equals("End")) {
            String name = names;

            for (Citizen c : citizens) {
                if (c.getName().equals(name)) {
                    c.buyFood();
                }
            }

            for (Rebel r : rebels) {
                if (r.getName().equals(name)) {
                    r.buyFood();
                }
            }
            names = scanner.nextLine();
        }
        int totalAmountFoodCitizens = citizens.stream().mapToInt(Citizen::getFood).sum();
        int totalAmountFoodRebels = rebels.stream().mapToInt(Rebel::getFood).sum();

        System.out.println(totalAmountFoodCitizens + totalAmountFoodRebels);
    }

}
