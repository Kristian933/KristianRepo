package HealthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name;
    private List<Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Salad salad) {
        data.add(salad);
    }

    public boolean buy(String name) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                data.remove(i);
                return true;
            }
        }
        return false;
    }

    public String getHealthiestSalad() {
        String healthiestSalad = "";
        int minCalories = Integer.MIN_VALUE;

        for (Salad salad : data) {
            int calories = salad.getTotalCalories();
            if (minCalories < calories) {
                minCalories = calories;
                healthiestSalad = salad.getName();
            }
        }
        return healthiestSalad;

    }

    public String generateMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s have %d salads:%n",this.name,this.data.size()
        )).append(System.lineSeparator());
        for (Salad salad : data) {
            stringBuilder.append(salad.getName())
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }

}
