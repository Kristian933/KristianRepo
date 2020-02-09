package HealthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {

    private String name;
    private List<Vegetable> vegetables;

    public Salad(String name) {
        this.name = name;
        this.vegetables = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getTotalCalories() {
        int calories = 0;

        for (Vegetable vegetable : vegetables) {
            calories += vegetable.getCalories();
        }

        return calories;
    }

    public int getProductCount() {
        return vegetables.size();
    }

    public void add(Vegetable product) {
        this.vegetables.add(product);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("* Salad %s is %d calories and have %d products:", this.getName()
                , getTotalCalories(), getProductCount())).append(System.lineSeparator());

        for (Vegetable vegetable : vegetables) {
            stringBuilder.append(String.format("- %s have %d calories"
                    ,vegetable.getName(),vegetable.getCalories())).append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }
}
