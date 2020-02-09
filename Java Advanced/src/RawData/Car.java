package RawData;
import java.util.List;
import java.util.Map;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tires> tires;


    public Car(String model, Engine engine, Cargo cargo,
               List<Tires> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }


    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public List<Tires> getTires() {
        return tires;
    }
}
