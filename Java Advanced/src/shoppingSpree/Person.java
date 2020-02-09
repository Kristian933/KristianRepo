package shoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setMoney(double money) {
        Validator.validateCost(money);
        this.money = money;
    }

    private void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void buyProduct(Product product) {
        double cost = product.getCost();
        if (this.money >=  cost){
            this.money -= cost;
            this.products.add(product);
        }else {
            throw new IllegalStateException(String.format("%s can't afford %s",
                    this.getName(), product.getName()));
        }

    }
}
