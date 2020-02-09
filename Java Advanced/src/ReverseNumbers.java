import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");
        ArrayDeque<Integer> reverseNumbers = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            reverseNumbers.add(Integer.valueOf(numbers[i]));
        }

        for (int i = reverseNumbers.size(); i > 0; i--) {
            System.out.print(reverseNumbers.pollLast() + " ");
        }
    }
}
