import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headSetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int trashedHeadSet = lostGames / 2;
        int trashedMouse = lostGames / 3;
        int trashedKeyboard = lostGames / 6;
        int trashedDisplays = lostGames / 12;

        double gamesCost =
                trashedHeadSet * headSetPrice
                        + trashedMouse * mousePrice
                        + trashedKeyboard * keyboardPrice
                        + trashedDisplays * displayPrice;

        System.out.printf("Rage expenses: %.2f lv.",gamesCost);


    }
}
