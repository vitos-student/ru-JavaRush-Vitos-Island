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
    private  final ConcurrentHashMap<Class<? extends Location>, Integer> plantsS = new ConcurrentHashMap<>();
   // private  final Location[][] locationsPlant;

//    public Location getLocationsPlant(int x,int y) {
//        return locationsPlant[x][y];
//    }
//
//    public Plant(Location[][] locations) {
//        this.locationsPlant = locations;
//    }

    public int getSumPlant() {
        int sum = 0;
        for (Integer value : getPlantsS().values()) {
            sum += (int) value;
        }
        return sum;
    }

    public void initPlant(Location[][] location) {
        for(Location[] locY:location){
            for(Location locXY:locY){
                plantsS.put(locXY.getClass(), ConfigVar.WEIGHT_PLANT);
            }
        }
        System.out.println("Трава начала расти!!!");
    }

    /**
     * рост травы от 0 до 100
     */
    public void addPlant() {
        plantsS.forEach((key, value) -> {
            if (value <= 90) {
                plantsS.compute(key, (k, v) -> v + 10);
            }
        });
    }

    public ConcurrentHashMap<Class<? extends Location>, Integer> getPlantsS() {
        return plantsS;
    }

    public int getValue(Location location){
        Class<? extends Location> locationClass = location.getClass();
        return plantsS.getOrDefault(locationClass, 0).intValue();    }


}