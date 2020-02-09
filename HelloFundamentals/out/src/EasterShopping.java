import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shops = Arrays.stream(scanner.nextLine()
                .split(" ")).collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String command = input[0];

            if (command.equals("Include")) {
                String shop = input[1];
                shops.add(shop);

            } else if (command.equals("Visit")) {
                int numberOfShops = Integer.parseInt(input[2]);
                String firstOrLast = input[1];
                remove(shops, firstOrLast, numberOfShops);


            } else if (command.equals("Prefer")) {
                int shop1 = Integer.parseInt(input[1]);
                int shop2 = Integer.parseInt(input[2]);
                swapByCollections(shops,shop1,shop2);


            } else {
                String shop = input[1];
                int index = Integer.parseInt(input[2]);
                place(shops, shop, index);
            }
        }
        System.out.println("Shops left:");
        for (int i = 0; i < shops.size(); i++) {
            System.out.print(shops.get(i) + " ");
        }

    }

    private static void swapByCollections(List<String> shops, int shop1, int shop2) {

        if (isValidIndex(shops,shop1)&&isValidIndex(shops,shop2)) {
            Collections.swap(shops, shop1, shop2);
        }
    }

    private static void remove(List<String> shops, String firstOrLast, int numberOfShops) {

        if (numberOfShops <= shops.size()) {
            if (firstOrLast.equals("first")) {
                for (int i = 0; i < numberOfShops; i++) {
                    shops.remove(shops.get(0));
                }
            } else {
                for (int i = 0; i < numberOfShops; i++) {
                    shops.remove(shops.size() - 1);
                }
            }
        }
    }

    private static void place(List<String> shops, String shop, int index) {
        if (isValidIndex(shops, index)) {
            shops.add(index + 1, shop);
        }
    }

    private static boolean isValidIndex(List<String> shops, int index) {
        return 0 <= index && index < shops.size();
    }
}
