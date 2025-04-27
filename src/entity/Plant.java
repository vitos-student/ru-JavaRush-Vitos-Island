package entity;

import repository.ConfigVar;

import java.util.concurrent.ConcurrentHashMap;

/**
 * класс растения
 * предполагается :
 * есть вес, от 0 до 100 кг
 * есть локация, где данная трава будет расти.
 */

public class Plant {
    private  final ConcurrentHashMap<Location, Integer> plants = new ConcurrentHashMap<>();

    public int getSumPlant() {
        int sum = 0;
        for (Integer value : getPlants().values()) {
            sum += (int) value;
        }
        return sum;
    }

    public  Plant(Location[][] location) {
        for(Location[] locY:location){
            for(Location locXY:locY){
                plants.put(locXY, ConfigVar.WEIGHT_PLANT);
            }
        }
        System.out.println("Трава начала расти!!!");
    }

    public ConcurrentHashMap<Location, Integer> getPlants() {
        return this.plants;
    }


}