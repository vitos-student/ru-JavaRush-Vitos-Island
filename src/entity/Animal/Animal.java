package entity.Animal;

import entity.Island;
import entity.Location;

import java.util.concurrent.ConcurrentHashMap;

public class Animal {
    protected boolean isAlive ;
    protected final String nameAnimal;
    protected final int weight;
    protected final int step;
    protected final int maxCountLocation;
    private  int eatAnimal;
    protected final Location location;

    public Animal(String nameAnimal, int weight, int step, int maxCountLocation, int eatAnimal, Location location) {
        this.isAlive = true;
        this.nameAnimal = nameAnimal;
        this.weight = weight;
        this.step = step;
        this.maxCountLocation = maxCountLocation;
        this.eatAnimal = eatAnimal;
        this.location = location;
    }

    public void initAnimal(String name, Island island){
        System.out.println("Создаем животное:" + name);
      //  this.locations=locations;
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

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void seteEatAnimal(int eatAnimal) {
        this.eatAnimal += eatAnimal;
    }



}
