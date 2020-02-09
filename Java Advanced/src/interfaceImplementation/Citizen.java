package interfaceImplementation;

public class Citizen implements Person, Identifiable, Birthable, Buyer {
    private String name;
    private int age;
    private String birthDate;
    private String id;
    private int food = 0;


    public Citizen(String name, int age, String birthDate, String id) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.id = id;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public void buyFood() {
        this.food = getFood() + 10;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
