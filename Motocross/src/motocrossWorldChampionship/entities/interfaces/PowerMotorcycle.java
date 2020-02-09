package motocrossWorldChampionship.entities.interfaces;

import static motocrossWorldChampionship.common.ExceptionMessages.INVALID_HORSE_POWER;

public class PowerMotorcycle extends MotorcycleImpl {
    private final static double CUBIC_CENTIMETRES = 450;
    private final static int MINIMUM_HORSEPOWER = 70;
    private final static int MAX_HORSEPOWER = 100;

    public PowerMotorcycle(String model, int horsePower) {
        super(model, setHorsePower(horsePower), CUBIC_CENTIMETRES);
    }

    private static int setHorsePower(int horsePower) {
        if (horsePower < MINIMUM_HORSEPOWER || horsePower > MAX_HORSEPOWER){
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER,horsePower));
        }
        return horsePower;
    }

}
