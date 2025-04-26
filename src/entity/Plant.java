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
    private final ConcurrentHashMap<Class<? extends Location>, Integer> plantsS = new ConcurrentHashMap<>();
    private final Location[][] locationsPlant;

    public Location[][] getLocationsPlant() {
        return locationsPlant;
    }

    public Plant(Location[][] locations) {
        this.locationsPlant = locations;
    }

    public int getSumPlant() {
        int sum = 0;
//        for (int i = 0; i < ConfigVar.X; i++) {
//            for (int j = 0; j < ConfigVar.Y; j++) {
//                sum += plantsS.get(locationsPlant[i][j].getClass());
//            }
//        }
        for (Integer value : plantsS.values()) {
            sum += (int) value;
        }
        return sum;
    }

    public void initPlant() {
        for (int i = 0; i < ConfigVar.X; i++) {
            for (int j = 0; j < ConfigVar.Y; j++) {
                plantsS.put(locationsPlant[i][j].getClass(), ConfigVar.WEIGHT_PLANT);
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


}
