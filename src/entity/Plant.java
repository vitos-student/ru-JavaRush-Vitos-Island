package entity;



public class Plant {
    private double weight;
    private Location[][] locationsPlants;

    public Plant(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public Location[][] getLocationsPlants() {
        return locationsPlants;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setLocationsPlants(Location[][] locationsPlants) {
        this.locationsPlants = locationsPlants;
    }
}
