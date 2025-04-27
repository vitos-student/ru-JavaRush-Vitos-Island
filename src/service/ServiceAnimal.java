package service;

import entity.Animal.Animal;
import entity.Island;
import entity.Location;
import entity.Plant;

import java.util.ArrayList;
import java.util.List;


public class ServiceAnimal {
    public final Island island;
    public List<Animal> animalList = new ArrayList<>();

    public ServiceAnimal(Island island) {
        this.island = island;
        for (Location[] loc : island.getLocations()) {
            for (Location locXY : loc) {
                this.animalList.add(new Animal("COW", 700, 1, 1, 10, 30, 70,locXY));
            }
        }
    }

    public int getSumWeight() {
        int sumW = 0;
        for (Animal animal1 : animalList) {
            sumW += animal1.getWeight();
        }
        return sumW;
    }

    public int getSumEatAnimal() {
        int sumW = 0;
        for (Animal animal1 : animalList) {
            sumW += animal1.getEatAnimal();
        }
        ;
        return sumW;
    }

    public void addAnimalWeight(Plant plant) {
        for (Animal animal : animalList) {
            Location loc = animal.getLocation();
            /**проверяем что есть трава в локации, но берем не 0, а больше потребления*/
            if (plant.getPlants().get(loc).intValue() > animal.getEatAnimal()) {
                animal.setEatAnimal(animal); /**покормили животное*/
                plant.getPlants().put(loc,plant.getPlants().get(loc).intValue() - animal.getEatAnimal()); /** уменьшили траву */
            }

        }
    }


    /***********************
     ******************* * статистика * *********************
     ************************ */

    /**
     * съедено еды
     */
    public int getSumAnimalEat() {
        int SumAnimalEat = 0;
        for (Animal animal : animalList) {
            SumAnimalEat += (int) animal.getSatiety();
        }
        return SumAnimalEat;
    }

    /**
     * Общая сытость
     */
    public int getSumAllSatiety() {
        int sumAllSatiety = 0;
        for (Animal animal : animalList) {
            sumAllSatiety += (int) animal.getSatiety();
        }
        return sumAllSatiety;
    }

}
