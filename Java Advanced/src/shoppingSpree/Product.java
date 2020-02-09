package shoppingSpree;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    public void setCost(double cost) {
        Validator.validateCost(cost);
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
