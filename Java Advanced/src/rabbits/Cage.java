package rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {

    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (getCapacity() > data.size()){
            data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                data.remove(i);
                return true;
            }
        }
        return false;
    }

    public void removeSpecies(String species) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getSpecies().equals(species)) {
                data.remove(i);
            }
        }
    }

    public String sellRabbit(String name) {
        String rabbitName = "";

        for (Rabbit rabbit : data) {
            if (rabbit.getName().equals(name)) {
                rabbit.setAvailable(false);
                rabbitName = "Rabbit " + "(" + rabbit.getSpecies() + ")" + ": " + rabbit.getName();
                break;
            }
        }

        return rabbitName;

    }


    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> rabbits = new ArrayList<>();
        for (Rabbit datum : data) {
            if (datum.getSpecies().equals(species)) {
                rabbits.add(datum);
                datum.setAvailable(false);
            }
        }


        return rabbits;

    }

    public int count() {
        return data.size();
    }

    public StringBuilder report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Rabbits available at %s:", this.name))
                .append(System.lineSeparator());
        for (Rabbit datum : data) {
            if (datum.isAvailable()) {
                stringBuilder.append(String.format("Rabbit %s: %s", datum.getSpecies(), datum.getName()))
                        .append(System.lineSeparator());
            }
        }

        return stringBuilder;


    }

}
