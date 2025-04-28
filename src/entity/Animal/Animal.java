package entity.Animal;

import entity.Island;
import entity.Location;
import repository.ConfigVar;
import utils.RandomizerLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Иду по упрощенной схеме. на 1 локации только 1 животное
 * сильно логику не хочу сейчас усложнять
 * пока будут только животные кушающие траву
 */

public class Animal {
    protected boolean isAlive;
    protected final String nameAnimal;
    protected final int weight;
    protected final int step;
    protected  int countAnimalLocation;
    protected final int maxCountLocation;
    private int eatAnimal;
    private int satiety;
    private int satietyMax;
    protected final Location location;
    RandomizerLocation randomizerLocation = new RandomizerLocation();


    public Animal(String nameAnimal, int weight, int step,int countAnimalLocation, int maxCountLocation, int eatAnimal, int satiety, int satietyMax, Location location) {
        this.isAlive = true;                       //признак живой или нет
        this.nameAnimal = nameAnimal;              //животное
        this.weight = weight;                      //вес
        this.step = step;                          //шаг движения
        this.countAnimalLocation = countAnimalLocation;
        this.maxCountLocation = maxCountLocation;  //max колличество на острове
        this.eatAnimal = eatAnimal;                //потребление еды
        this.satiety=satiety;
        this.satietyMax =satietyMax;               //мах сытость
        this.location = location;                  //локация
    }


    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public int getSatietyMax() {
        return satietyMax;
    }

    public void initAnimal(String name, Island island) {
        System.out.println("Создаем животное:" + name);
        //  this.locations=locations;
    }

    public int getCountAnimalLocation() {
        return countAnimalLocation;
    }

    /** передаем позицию, ищем новую локацию, возвращаем лист*/
    public List<Integer> moveNowAnimal(int xAnimal, int yAnimal, int stepAnimal) {
        List<Integer> integerlist = new ArrayList<>();
        int xRandom = randomizerLocation.nextInt(stepAnimal);
        int yRandom = randomizerLocation.nextInt(stepAnimal);
        int xNextAnimal = xAnimal;
        int yNextAnimal = yAnimal;
        if (xAnimal+xRandom> ConfigVar.X) {
            xNextAnimal-=xRandom;
        };
        if (yAnimal+yRandom> ConfigVar.Y) {
            yNextAnimal-=yRandom;
        }
        integerlist.add(xNextAnimal);
        integerlist.add(yNextAnimal);
        return integerlist;
    }

//    public Animal setNextLocationAnimal() {
//        return this.;
//    }



    public void eatAnimal() {
    }

    public boolean isAlive() {
        return isAlive;
    }

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

    /**
     * животные кушают.
     */

    public void setEatAnimal(Animal animal) {
        if (animal.satiety<animal.satietyMax) {
            this.satiety += eatAnimal;
        }
    }

    public Location getLocation() {
        return location;
    }

    public void setCountAnimalLocation(int countAnimalLocation) {
        int i = this.countAnimalLocation;
        this.countAnimalLocation =i+ countAnimalLocation;
    }


}
