import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int pushNumbers = Integer.parseInt(input[0]);
        int popNumbers = Integer.parseInt(input[1]);
        int check = Integer.parseInt(input[2]);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        int smallest = Integer.MAX_VALUE;

        String[] numbersToAdd = scanner.nextLine().split(" ");

        for (int i = 0; i < pushNumbers; i++) {
            numbers.push(Integer.parseInt(numbersToAdd[i]));
        }
        for (int i = 0; i < popNumbers; i++) {
            numbers.pop();
        }

        if (numbers.contains(check)) {
            System.out.println("true");
        } else {
            if (numbers.size() == 0) {
                System.out.println(0);
            }
            for (int i = numbers.size(); i > 0; i--) {
                if (numbers.peekFirst() < smallest) {
                    smallest = numbers.pop();
                }
            }
            System.out.println(smallest);
        }


    }
}
