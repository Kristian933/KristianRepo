import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();


        if (sumCounterAndPrint(password) & onlyLettersAndDigits(password) & atLeast2Digits(password)) {
            System.out.println("Password is valid");
        }

    }

    static boolean sumCounterAndPrint(String count) {
        int sum = count.length();
        if (sum >= 10 || sum <= 6) {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        } else {
            return true;
        }
    }

    static boolean onlyLettersAndDigits(String password) {
        boolean letterCheck = false;
        boolean digitsCheck = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isAlphabetic(password.charAt(i))) {
                letterCheck = true;
            }
            if (Character.isDigit(password.charAt(i))) {
                digitsCheck = true;
            }
        }
        if (!letterCheck & !digitsCheck) {
            System.out.println("Password must consist only of letters and digits");
            return false;
        } else {
            return true;
        }
    }

    static boolean atLeast2Digits(String password) {
        int sum = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                sum++;
            }
        }
        if (sum < 2) {
            System.out.println("Password must have at least 2 digits");
            return false;
        } else {
            return true;
        }
    }
}
