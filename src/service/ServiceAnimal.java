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
    public Location location;

    public ServiceAnimal(Island island) {
        this.island = island;
        for (Location[] loc : island.getLocations()) {
            for (Location locXY : loc) {
                this.animalList.add(new Animal("COW", 700, 1, 1, 1, 10, 30, 70, locXY));
            }
        }
        // this.location =
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
                plant.getPlants().put(loc, plant.getPlants().get(loc).intValue() - animal.getEatAnimal()); /** уменьшили траву */
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

    public void moveAnimal(ServiceAnimal serviceAnimal) {
        List<Integer> newLoc = new ArrayList<>();
        for (Animal animal : animalList) {
            /** переход работает, только если на острове были животные*/
            if (animal.getCountAnimalLocation() > 0) {
                newLoc = animal.moveNowAnimal(animal.getLocation().getX(), animal.getLocation().getY(), animal.getStep());
                Animal animalNextLocation = serviceAnimal.animalNextLocation(island.getLocationsIsland(newLoc.get(0), newLoc.get(1)));
               // System.out.println("Старые значения :" + animal.getLocation().getX()+animal.getLocation().getY());
               // System.out.println("Новые значения :" + newLoc.get(0)+ newLoc.get(1));
                /** уменьшаем количесво животных на текущий локации */
                animal.setCountAnimalLocation(-1);
                /** увеличиваем животных*/
                animalNextLocation.setCountAnimalLocation(1);
                newLoc.clear();
            }
        }
    }

    public Animal animalNextLocation(Location location) {
        Animal nextLocationAnimal = null;
        for (Animal animal : animalList) {
            if (animal.getLocation().equals(location)) {
                nextLocationAnimal = animal;
            }
        }
        return nextLocationAnimal;
    }

    /**
     * мах животных на острове
     */
    public int getMaxAnimalLocation() {
        int MaxAnimalLocation = 0;
        for (Animal animal : animalList) {
            if (animal.getCountAnimalLocation() > MaxAnimalLocation) {
                MaxAnimalLocation = animal.getCountAnimalLocation();
            }

        }
        return MaxAnimalLocation;
    }


}
