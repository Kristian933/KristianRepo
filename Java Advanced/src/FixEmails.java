import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> namesAndEmails = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            String email = scanner.nextLine();
            if (email.contains(".bg")) {
                namesAndEmails.put(input, email);
            }
            input = scanner.nextLine();
        }

        namesAndEmails.forEach((k, v) -> {
            System.out.println(k + " -> " + v);
        });
    }
}
