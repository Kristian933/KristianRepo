import java.util.*;

public class FeedTheAnimals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> nameAndFood = new HashMap<>();
        Map<String, Integer> nameAndArea = new HashMap<>();


        while (!input.equals("Last Info")) {
            String[] tokens = input.split(":");
            String command = tokens[0];
            String name = tokens[1];
            int food = Integer.parseInt(tokens[2]);
            String area = tokens[3];

            if (command.equals("Add")) {
                if (!nameAndFood.containsKey(name)) {
                    nameAndFood.put(name, food);
                    if (!nameAndArea.containsKey(area)) {
                        nameAndArea.put(area, 1);
                    } else {
                        nameAndArea.put(area, nameAndArea.get(area) + 1);
                    }
                } else {
                    nameAndFood.put(name, nameAndFood.get(name) + food);
                }
            } else {
                if (nameAndFood.containsKey(name) && nameAndArea.containsKey(area)) {
                    nameAndFood.put(name, nameAndFood.get(name) - food);
                    if (nameAndFood.get(name) <= 0) {
                        System.out.printf("%s was successfully fed%n", name);
                        nameAndFood.remove(name);
                        nameAndArea.put(area, nameAndArea.get(area) - 1);
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.println("Animals:");

        nameAndFood.entrySet().stream().sorted((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(entry ->
                System.out.println(String.format("%s -> %dg", entry.getKey(), entry.getValue())));

        System.out.println("Areas with hungry animals:");

        nameAndArea.entrySet().stream().sorted((a, b) -> b.getKey().compareTo(a.getKey()))
                .filter(a -> a.getValue() > 0)
                .forEach(entry -> System.out.println(String.format("%s : %s", entry.getKey(), entry.getValue())));


    }
}
