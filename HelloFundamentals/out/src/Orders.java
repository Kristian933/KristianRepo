import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, ArrayList<Double>> table = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String[] tokens = input.split("\\s+");

            String product = tokens[0];
            ArrayList<Double> priceAndQuantity = new ArrayList<>(Arrays.asList(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])));

            if (!table.containsKey(product)) {
                table.put(product, priceAndQuantity);
            } else {
                table.put(product, updatePriceAndQuantity(table.get(product), priceAndQuantity));
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, ArrayList<Double>> entry : table.entrySet()) {
            System.out.println(String.format("%s -> %.2f", entry.getKey(), entry.getValue().get(0) * entry.getValue().get(1)));
        }
    }


    public static ArrayList<Double> updatePriceAndQuantity(ArrayList<Double> current, ArrayList<Double> updated) {
        current.set(0, updated.get(0));
        current.set(1, current.get(1) + updated.get(1));

        return current;
    }


}
