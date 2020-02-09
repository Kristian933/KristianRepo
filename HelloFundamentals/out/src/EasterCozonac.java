import java.util.Scanner;

public class EasterCozonac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double priceForFlower = Double.parseDouble(scanner.nextLine());

        double eggsPack = priceForFlower - (priceForFlower * 0.25);
        double milkPriceForOneLitter = priceForFlower + (priceForFlower * 0.25);
        double milkPriceFor250Ml = milkPriceForOneLitter / 4;

        double totalPriceForCozonac = priceForFlower + eggsPack + milkPriceFor250Ml;

        int coloredEggs = 0;
        int cozonacsMade = 0;
        int counter = 0;

        while (budget >= 0) {
            budget -= totalPriceForCozonac;
            cozonacsMade++;
            coloredEggs += 3;
            counter++;
            if (counter == 3) {
                int delete = cozonacsMade - 2;
                coloredEggs -= delete;
                counter = 0;
            }
            if (totalPriceForCozonac > budget) {
                break;
            }

        }
        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.", cozonacsMade, coloredEggs, budget);
    }
}
