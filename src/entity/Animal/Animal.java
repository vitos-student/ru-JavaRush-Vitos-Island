package entity.Animal;

import entity.Location;

import java.util.concurrent.ConcurrentHashMap;

public abstract class Animal {
    protected boolean isAlive = true;
    protected  String nameAnimal;
    protected final int weight;
    protected final int step;
    protected final int maxCountLocation;
    protected final int eatAnimal;
    protected Location[][] locations;

    protected Animal(int weight, int step, int maxCountLocation, int eatAnimal) {
        this.weight = weight;
        this.step = step;
        this.maxCountLocation = maxCountLocation;
        this.eatAnimal = eatAnimal;
    }


    public void initAnimal(String name,Location[][] locations){
        System.out.println("Создаем животное:" + name);
        this.locations=locations;
    }

    public void moveAnimal(){}

    public void eatAnimal(){}

    public boolean isAlive() { return isAlive; }

    public String getNameAnimal() {
        return nameAnimal;
    }

    public int getWeight() {
        return weight;
    }

    public int getStep() {
        return step;
    }

    public int getMaxCountLocation() {
        return maxCountLocation;
    }

    public int getEatAnimal() {
        return eatAnimal;
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setNameAnimal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }
}
