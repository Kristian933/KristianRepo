package animalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        ValidateName(name);
        this.name = name;
    }

    private void setAge(int age) {
        ValidateAge(age);
        this.age = age;
    }

    private double productPerDay() {
        double producingPerDay = 0;
        return producingPerDay = calculateProductPerDay(age);
    }

    private double calculateProductPerDay(int age) {
        double produce = 0;
        if (age >= 0 && age <= 5) {
            produce = 2;
        } else if (age >= 6 && age <= 11) {
            produce = 1;
        } else {
            produce = 0.75;
        }
        return produce;
    }


    private void ValidateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    private void ValidateAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",
                this.name,this.age ,productPerDay());
    }
}
