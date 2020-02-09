import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, String> contacts = new LinkedHashMap<>();

        while (!command.equals("search")) {
            String[] namesAndNumbers = command.split("-");
            String name = namesAndNumbers[0];
            String number = namesAndNumbers[1];

            contacts.putIfAbsent(name, number);
            if (contacts.containsKey(name)) {
                contacts.replace(name, number);
            }
            command = scanner.nextLine();
        }
        command = scanner.nextLine();
        while (!command.equals("stop")) {

            if (contacts.containsKey(command)) {
                System.out.println(command + " -> " + contacts.get(command));
            } else {
                System.out.println("Contact " + command + " does not exist.");
            }
            command = scanner.nextLine();
        }
    }
}
