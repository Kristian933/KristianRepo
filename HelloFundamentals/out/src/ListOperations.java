import java.util.*;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(" +")).map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split(" +");


            if (input.contains("Add")) {
                numbers.add(Integer.parseInt(tokens[1]));

            } else if (input.contains("Insert")) {
                int index = Integer.parseInt(tokens[2]);
                if (index > numbers.size()) {
                    System.out.println("Invalid index");
                    break;
                }
                int position = Integer.parseInt(tokens[1]);
                numbers.add(index, position);


            } else if (input.contains("Remove")) {
                int index = Integer.parseInt(tokens[1]);
                if (index > numbers.size()) {
                    System.out.println("Invalid index");
                } else {
                    numbers.remove(Integer.parseInt(tokens[1]));
                }

            } else if (input.contains("left")) {
                int shifting = Integer.parseInt(tokens[2]);
                for (int i = 0; i < shifting; i++) {
                    int shiftingElements = numbers.remove(0);
                    numbers.add(shiftingElements);
                }
            } else if (input.contains("right")) {
                int shifting = Integer.parseInt(tokens[2]);
                for (int i = 0; i < shifting; i++) {
                    int shiftingElements = numbers.remove(numbers.size() - 1);
                    numbers.add(0, shiftingElements);
                }
            }
            input = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }



    }
}
