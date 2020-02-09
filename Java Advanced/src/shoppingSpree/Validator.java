package shoppingSpree;

public class Validator {

    private Validator(){

    }

    public static void validateCost(double cost) {
        if (cost < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }


    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }
}
