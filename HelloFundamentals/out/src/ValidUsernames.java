import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> userNames = Arrays.stream(scanner.nextLine()
                .split(", ")).collect(Collectors.toList());


        for (String userName : userNames) {
            if (isValidUsername(userName)){
                System.out.println(userName);
            }
        }

    }

    private static boolean isValidUsername(String userNames) {
        if (userNames.length() < 3 || userNames.length() > 16) {
           return false;
        }
        for (int i = 0; i < userNames.length(); i++) {
            char symbol = userNames.charAt(i);
            if (!Character.isLetterOrDigit(symbol) && symbol != '-'
                    && symbol != '_'){
                return false;
            }
        }
        return true;
    }
}
