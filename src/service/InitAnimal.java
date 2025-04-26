package service;

import entity.Animal.Animal;
import entity.Island;
import entity.Location;

import java.util.ArrayList;
import java.util.List;


public class InitAnimal {
    public final Island island;
    public List<Animal> animal = new ArrayList<>();

    public InitAnimal(Island island) {
        this.island = island;
        for (Location[] loc : island.getLocations()) {
            for (Location locXY : loc) {
                this.animal.add(new Animal("COW", 1, 1, 1, 1, locXY));
                System.out.println(locXY);
            }
        }
    }

    public int getSumWeight() {
        int sumW = 0;
        for (Animal animal1 : animal) {
            sumW += animal1.getWeight();
        }
        ;
        return sumW;
    }

    public int getSumEatAnimal() {
        int sumW = 0;
        for (Animal animal1 : animal) {
            sumW += animal1.getEatAnimal();
        }
        ;
        return sumW;
    }

    public void addAnimalWeight() {
        for (Animal animal1 : animal) {
            animal1.seteEatAnimal(1);
        }
    }
}
