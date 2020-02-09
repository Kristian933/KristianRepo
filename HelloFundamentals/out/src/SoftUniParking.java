import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, String> userNameAndPlate = new LinkedHashMap<>();


        for (int i = 0; i < number; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");

            if (tokens[0].equals("register")) {
                if (!userNameAndPlate.containsKey(tokens[1])) {
                    userNameAndPlate.put(tokens[1], tokens[2]);
                    System.out.println(String.format("%s registered %s successfully", tokens[1], tokens[2]));
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", userNameAndPlate.get(tokens[1]));
                }
            } else {
                if (userNameAndPlate.containsKey(tokens[1])){
                    userNameAndPlate.remove(tokens[1]);
                    System.out.printf("%s unregistered successfully%n",tokens[1]);
                }else {
                    System.out.printf("ERROR: user %s not found%n",tokens[1]);
                }
            }

        }

        for (Map.Entry<String, String> entry : userNameAndPlate.entrySet()) {
            System.out.println(String.format("%s => %s",entry.getKey(),entry.getValue()));
        }

    }
}
