import java.util.Scanner;

public class VendingMashine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double money ;
        String input = scanner.nextLine();

        double sum = 0;
        double price = 0;


        while (!"Start".equals(input)) {
            money = Double.parseDouble(input);
            if (money == 0.10 || money == 0.20 || money == 0.50 || money == 1.00 || money == 2.00) {
                sum += money;
            } else {
                System.out.printf("Cannot accept %.2f%n", money);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        double afterBuy = 0 + sum;
        while (!"End".equals(input)) {
            switch (input) {
                case "Nuts":
                    price = 2.0;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1.0;
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            if (afterBuy >= price && price != 0) {
                afterBuy -= price;
                System.out.printf("Purchased %s%n", input);
            }else if (price > afterBuy) {
                System.out.println("Sorry, not enough money");
            }
            input = scanner.nextLine();
        }
        System.out.printf("Change: %.2f",afterBuy);
    }


}
