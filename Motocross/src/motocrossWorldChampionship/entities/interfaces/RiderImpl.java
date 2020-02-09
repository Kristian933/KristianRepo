package motocrossWorldChampionship.entities.interfaces;

import static motocrossWorldChampionship.common.ExceptionMessages.INVALID_NAME;
import static motocrossWorldChampionship.common.ExceptionMessages.MOTORCYCLE_INVALID;

public class RiderImpl implements Rider {
    private String name;
    private Motorcycle motorcycle;
    private int numberOfWins;
    private boolean canParticipate = false;

    public RiderImpl(String name) {
        this.setName(name);
        this.numberOfWins = 0;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 5){
            throw new IllegalArgumentException(String.format(INVALID_NAME,name,5));
        }
            this.name = name;
    }

    private void setMotorcycle(Motorcycle motorcycle) {
        this.motorcycle = motorcycle;
    }

    private void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    private void setCanParticipate(boolean canParticipate) {
        this.canParticipate = canParticipate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Motorcycle getMotorcycle() {
        return motorcycle;
    }

    @Override
    public int getNumberOfWins() {
        return numberOfWins;
    }


    @Override
    public void addMotorcycle(Motorcycle motorcycle) {
        if (motorcycle == null){
            throw new NullPointerException(MOTORCYCLE_INVALID);
        }
        this.motorcycle = motorcycle;
        this.canParticipate = true;
    }

    @Override
    public void winRace() {
        this.numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return this.canParticipate;
    }
}
