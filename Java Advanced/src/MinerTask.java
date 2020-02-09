import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, Integer> recourseAndQuantity = new LinkedHashMap<>();

        while (!command.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!recourseAndQuantity.containsKey(command)) {
                recourseAndQuantity.put(command, quantity);
            } else {
                recourseAndQuantity.replace(command, recourseAndQuantity.get(command) + quantity);
            }

            command = scanner.nextLine();
        }

        recourseAndQuantity.forEach((k, v) -> {
            System.out.println(k + " -> " + v);
        });

    }
}
