import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int commands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < commands; i++) {
            String[] input = scanner.nextLine().split(" ");

            if (input[0].equals("1")) {
                numbers.push(Integer.parseInt(input[1]));
            } else if (input[0].equals("2")) {
                numbers.pop();
            } else {
                System.out.println(Collections.max(numbers));
            }

        }
    }
}
