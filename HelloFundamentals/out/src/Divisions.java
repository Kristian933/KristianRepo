import java.util.Scanner;

public class Divisions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numberDivisible = "";

        int number = Integer.parseInt(scanner.nextLine());
        int divided = 0;

        if (number % 10 == 0) {
            divided = 10;
        } else if (number % 7 == 0) {
            divided = 7;
        } else if (number % 6 == 0) {
            divided = 6;
        } else if (number % 3 == 0) {
            divided = 3;
        } else if (number % 2 == 0) {
            divided = 2;
        } else {
            System.out.println("Not divisible");
        }
        if (divided != 0) {
            System.out.printf("The number is divisible by %d", divided);
        }
    }
}
