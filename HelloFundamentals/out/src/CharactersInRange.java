import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstOne = scanner.nextLine().charAt(0);
        char secondOne = scanner.nextLine().charAt(0);

        countingAndPrinting(firstOne, secondOne);

    }

    static void countingAndPrinting(char one, char two) {
        if (one < two) {
            one++;
            for (char i = one; i < two; i++) {
                System.out.print(i + " ");
            }
        } else {
            two++;
            for (char i = two; i < one; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
