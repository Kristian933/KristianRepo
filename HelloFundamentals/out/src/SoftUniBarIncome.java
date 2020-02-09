import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "%([A-Z][a-z]+)%[^|$%.]*?<(\\w+)>[^|$%.]*?\\|(\\d+)\\|[^|$%.]*?([0-9]+\\.?[0-9]+)\\$";
        Pattern pattern = Pattern.compile(regex);
        double totalPrice = 0;
        double totalIncome = 0;

        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String name = matcher.group(1);
                String product = matcher.group(2);
                int quantity = Integer.parseInt(matcher.group(3));
                double price = Double.parseDouble(matcher.group(4));

                totalPrice = quantity * price;
                totalIncome += totalPrice;

                System.out.printf("%s: %s - %.2f%n", name, product, totalPrice);
            }
            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f", totalIncome);
    }
}
