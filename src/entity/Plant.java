package entity;

/**
 * класс растения
 * предполагается :
 * есть вес, от 0 до 100 кг
 * есть локация, где данная трава будет расти.
 * локацию задаю рандомно.
 */

public class Plant {
    private double weight;
    private Location[][] locationsPlants;

    public Plant() {
        this.weight=20;
        this.locationsPlants = new Location[1][1];
    }


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
