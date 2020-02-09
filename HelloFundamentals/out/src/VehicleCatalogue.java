import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {

    static class Vehicle {
        String type;
        String model;
        String color;
        int horsePower;

        Vehicle(String type, String model, String color, int horsePower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        public int getHorsePower() {
            return this.horsePower;
        }

        public String getModel() {
            return this.model;
        }

        public String getColor() {
            return this.color;
        }

        public String getType() {
            return
                    Character.toTitleCase(this.type.charAt(0)) +
                            this.type.substring(1);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Vehicle> vehicles = new ArrayList<>();


        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");

            String type = tokens[0];
            String model = tokens[1];
            String color = tokens[2];
            int horsePower = Integer.parseInt(tokens[3]);

            Vehicle vehicle = new Vehicle(type, model, color, horsePower);
            vehicles.add(vehicle);

            input = scanner.nextLine();

        }

        input = scanner.nextLine();

        while (!input.equals("Close the Catalogue")) {
            for (Vehicle vehicle : vehicles) {
                if (input.equals(vehicle.getModel())) {
                    System.out.println(String.format("Type: %s%n" +
                                    "Model: %s%n" + "Color: %s%n" +
                                    "Horsepower: %d", vehicle.getType(), vehicle.getModel(),
                            vehicle.getColor(), vehicle.getHorsePower()));
                }
            }


            input = scanner.nextLine();
        }
        double avgCarsHP = calculateAvgHP(vehicles, "Car");
        System.out.printf("Cars have average horsepower of: %.2f.%n", avgCarsHP);
        double avgTrucksHP = calculateAvgHP(vehicles,"Truck");
        System.out.printf("Trucks have average horsepower of: %.2f.", avgTrucksHP);

    }

    private static double calculateAvgHP(List<Vehicle> vehicles, String type) {
        int sum = 0;
        int counter = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equals(type)) {
                sum += vehicle.getHorsePower();
                counter++;
            }
        }
        double avg = 0;
        if (counter != 0){
            avg = sum / (counter * 1.0);
        }

        return avg;
    }

}
