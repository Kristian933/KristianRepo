package motocrossWorldChampionship.repositories.interfaces;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static motocrossWorldChampionship.common.ExceptionMessages.MOTORCYCLE_EXISTS;

public class MotorcycleRepository implements Repository<Motorcycle> {

    private Collection<Motorcycle> models;

    public MotorcycleRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Motorcycle getByName(String name) {
       Motorcycle motorcycle = null;
        for (Motorcycle model : models) {
            if (model.getModel().equals(name)){
                motorcycle = model;
            }
        }
        return motorcycle;
    }

    @Override
    public Collection<Motorcycle> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Motorcycle model) {
        if(this.models.contains(model)){
            throw new IllegalArgumentException(String.format(MOTORCYCLE_EXISTS,model.getModel()));
        }
        this.models.add(model);
    }

    @Override
    public boolean remove(Motorcycle model) {
        return this.models.remove(model);
    }
}
