package RawData;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();
        List<Tires> tires = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            String[] tokens = scanner.nextLine().split(" ");

            String model = tokens[0];
            int enginePower = Integer.parseInt(tokens[2]);
            String cargoType = tokens[4];
            for (int j = 5; j <= 11; j += 2) {
                double tirePressure = Double.parseDouble(tokens[j]);
                Tires tire = new Tires(tirePressure);
                tires.add(tire);
            }

            Car car = new Car(model, new Engine(enginePower),
                    new Cargo(cargoType), tires);

            cars.put(model, car);
            tires = new ArrayList<>();

        }

        String input = scanner.nextLine();

        List<String> car = new ArrayList<>();

        if (input.equals("fragile")) {
            cars.forEach((key, value) -> {
                if (!key.equals("fragile")) {
                    value.getTires().forEach(k -> {
                                if (k.getTirePressure() > 1) {
                                    if (!car.contains(key)){
                                        car.add(key);
                                    }
                                }
                            }

                    );
                }
            });
        } else{
            cars.forEach((key,value) ->{
                if (!key.equals("flamable")){
                    if (value.getEngine().getEngine()> 250){
                        if (!car.contains(key)){
                            car.add(key);
                        }
                    }
                }
            });
        }
        car.forEach(System.out::println);

    }
}
