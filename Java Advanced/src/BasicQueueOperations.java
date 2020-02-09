import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] operations = scanner.nextLine().split(" ");
        String[] numbers = scanner.nextLine().split(" ");
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (int i = 0; i < Integer.parseInt(operations[0]); i++) {
            queue.offer(numbers[i]);
        }
        for (int i = 0; i < Integer.parseInt(operations[1]); i++) {
            queue.remove(numbers[i]);
        }
        if (queue.contains(operations[2])) {
            System.out.println("true");
        } else if (queue.size() == 0) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
