import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        Map<String, Integer> nameSent = new HashMap<>();
        Map<String, Integer> nameReceived = new HashMap<>();

        while (!input.equals("Statistics")) {
            String[] tokens = input.split("=");
            String command = tokens[0];

            if (command.equals("Add")) {
                String name = tokens[1];
                int sent = Integer.parseInt(tokens[2]);
                int received = Integer.parseInt(tokens[3]);
                nameSent.putIfAbsent(name, sent);
                nameReceived.putIfAbsent(name, received);
            } else if (command.equals("Message")) {
                String sender = tokens[1];
                String receiver = tokens[2];
                if (nameSent.containsKey(sender) && nameReceived.containsKey(receiver)) {
                    nameSent.put(sender, nameSent.get(sender) + 1);
                    if (nameSent.get(sender) + nameReceived.get(sender) >= capacity) {
                        System.out.printf("%s reached the capacity!%n", sender);
                        nameSent.remove(sender);
                        nameReceived.remove(sender);
                    }
                    nameReceived.put(receiver, nameReceived.get(receiver) + 1);
                    if (nameSent.get(receiver) + nameReceived.get(receiver) >= capacity) {
                        System.out.printf("%s reached the capacity!%n", receiver);
                        nameSent.remove(receiver);
                        nameReceived.remove(receiver);
                    }
                }
            } else if (command.equals("Empty")) {
                String name = tokens[1];
                if (name.equals("All")) {
                    nameReceived.clear();
                    nameSent.clear();
                }
                nameReceived.remove(name);
                nameSent.remove(name);
            }
            input = scanner.nextLine();
        }
        System.out.printf("Users count: %d%n", nameSent.size());




        nameSent.forEach((key, value) -> nameSent.put(key, value + nameReceived.get(key)));
        nameSent.entrySet().stream().sorted((a, b) -> {
           int result = a.getKey().compareTo(b.getKey());
           if (result == 0) {
               result = b.getValue() .compareTo(a.getValue());
           }
          return result;
         }).forEach(entry -> {
             System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
         });
    }
}
