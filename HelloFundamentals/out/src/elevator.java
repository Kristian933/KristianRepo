import java.util.Scanner;

public class elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        for (char i = (char)number; i <= secondNumber ; i++) {
            System.out.print(i + " ");
        }

    }
}
