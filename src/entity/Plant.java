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
    private  final ConcurrentHashMap<Location, Integer> plantsS = new ConcurrentHashMap<>();

    public int getSumPlant() {
        int sum = 0;
        for (Integer value : getPlantsS().values()) {
            sum += (int) value;
        }
        return sum;
    }

    public  Plant(Location[][] location) {
        for(Location[] locY:location){
            for(Location locXY:locY){
                plantsS.put(locXY, ConfigVar.WEIGHT_PLANT);
            }
        }
        System.out.println("Трава начала расти!!!");
    }

    public ConcurrentHashMap<Location, Integer> getPlantsS() {
        return this.plantsS;
    }

}