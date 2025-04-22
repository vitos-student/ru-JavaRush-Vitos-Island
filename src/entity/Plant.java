package entity;

import repository.ConfigVar;

/**
 * класс растения
 * предполагается :
 * есть вес, от 0 до 100 кг
 * есть локация, где данная трава будет расти.
 * локацию задаю рандомно.
 */

public class Plant {
    private double weight;
    private Location locationsPlants;

    public Plant(Location location) {
        this.weight= ConfigVar.WEIGHT_PLANT;
        this.locationsPlants = location;
    }


    public double getWeight() {
        return weight;
    }

    public Location getLocationsPlants() {
        return locationsPlants;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setLocationsPlants(Location locationsPlants) {
        this.locationsPlants = locationsPlants;
    }


}
