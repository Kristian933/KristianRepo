package motocrossWorldChampionship.entities.interfaces;

import java.util.*;

import static motocrossWorldChampionship.common.ExceptionMessages.*;

public class RaceImpl implements Race {
    private String name;
    private int laps;
    private Map<String, Rider> riders;


    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.riders = new LinkedHashMap<>();

    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 5) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }
        this.name = name;
    }

    private void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_LAPS, 1));
        }
        this.laps = laps;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLaps() {
        return laps;
    }

    @Override
    public Collection<Rider> getRiders() {
        return new ArrayList<>(this.riders.values());
    }

    @Override
    public void addRider(Rider rider) {
        if (rider == null) {
            throw new NullPointerException(RIDER_INVALID);
        } else if (!rider.getCanParticipate()) {
            throw new IllegalArgumentException(String.format(RIDER_NOT_PARTICIPATE, rider));
        } else if (this.riders.containsKey(rider.getName())) {
            throw new IllegalArgumentException(String.format(RIDER_ALREADY_ADDED, rider, this.name));
        }
        this.riders.put(rider.getName(), rider);
    }
}
