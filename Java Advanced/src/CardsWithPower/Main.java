package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String power = scanner.nextLine();
        String suit = scanner.nextLine();

        Card card = Card.valueOf(power);
        Suits cardSuit = Suits.valueOf(suit);


        CardValue finalCard = new CardValue(card, cardSuit);

        System.out.println(finalCard.toString());

    }
}
