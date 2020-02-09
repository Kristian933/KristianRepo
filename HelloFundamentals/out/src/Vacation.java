import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String grope = scanner.nextLine();
        String day = scanner.nextLine();

        double price = 0;


        switch (day) {
            case "Friday":
                if (grope.equals("Students")) {
                    price = 8.45;
                } else if (grope.equals("Business")) {
                    price = 10.90;
                } else if (grope.equals("Regular")) {
                    price = 15;
                }
                break;
            case "Saturday":
                if (grope.equals("Students")) {
                    price = 9.80;
                } else if (grope.equals("Business")) {
                    price = 15.60;
                } else if (grope.equals("Regular")) {
                    price = 20;
                }
                break;
            case "Sunday":
                if (grope.equals("Students")) {
                    price = 10.46;
                } else if (grope.equals("Business")) {
                    price = 16;
                } else if (grope.equals("Regular")) {
                    price = 22.50;
                }
                break;
        }

        double totalPrice = people * price;

        if (grope.equals("Students") && people >= 30) {
            totalPrice = totalPrice - (totalPrice * 0.15);
            System.out.printf("Total price: %.2f", totalPrice);
        } else if (grope.equals("Business") && people >= 100) {
            people -= 10;
            double discount = people * price;
            System.out.printf("Total price: %.2f", discount);
        } else if (grope.equals("Regular") && people >= 10 && people <= 20) {
            totalPrice = totalPrice - (totalPrice * 0.05);
            System.out.printf("Total price: %.2f", totalPrice);
        }else {
            System.out.printf("Total price: %.2f", totalPrice);
        }

    }
}
