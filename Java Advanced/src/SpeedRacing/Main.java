package SpeedRacing;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < number; i++) {
            String[] tokens = scanner.nextLine().split(" ");

            String model = tokens[0];
            int fuel = Integer.parseInt(tokens[1]);
            double fuelCost = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuel, fuelCost, 0);

            cars.put(model, car);
        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split(" ");

            String model = tokens[1];
            int kilometers = Integer.parseInt(tokens[2]);

            cars.get(model).canTravel(model, cars.get(model).getFuelCost(), (int) cars.get(model).getFuel(),
                    kilometers, cars.get(model).getDistance());

            input = scanner.nextLine();
        }
        cars.forEach((key, value) -> System.out.printf("%s %.2f %.0f%n", key,
                value.getFuel(),value.getDistance()));
    }
}
