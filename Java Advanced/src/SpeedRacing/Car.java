package SpeedRacing;

public class Car {

    private String model;
    private double fuel;
    private double fuelCost;
    private double distance;

    public Car(String model, double fuel, double fuelCost, double distance) {
        this.model = model;
        this.fuel = fuel;
        this.fuelCost = fuelCost;
        this.distance = distance;
    }

    public void canTravel(String model, double fuelCost, int fuel, int kilometers, double distance) {
        double consume = kilometers * fuelCost;
        if (consume <= getFuel()) {
            this.fuel -= consume;
            this.distance += kilometers;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }


    public double getFuel() {
        return fuel;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public String getModel() {
        return this.model;
    }

    public double getDistance() {
        return distance;
    }
}
