package entity;

import repository.ConfigVar;

import java.util.concurrent.ConcurrentHashMap;

/**
 * класс растения
 * предполагается :
 * есть вес, от 0 до 100 кг
 * есть локация, где данная трава будет расти.
 * локацию задаю рандомно.
 */

public class Plant {
    private final ConcurrentHashMap<Class<? extends Location>, Integer> plantsS = new ConcurrentHashMap<>();


//    public int getSumPlant() {
//        int sum = 0;
//        for (int i = 0; i < ConfigVar.X; i++) {
//            for (int j = 0; j < ConfigVar.Y; j++) {
//                sum+=plantsS.get(locations[i][j].getClass());
//            }
//        }
//        return sum;
//    }
//
//    public void initPlant() {
//        for (int i = 0; i < ConfigVar.X; i++) {
//            for (int j = 0; j < ConfigVar.Y; j++) {
//                plantsS.put(locations[i][j].getClass(), ConfigVar.WEIGHT_PLANT);
//            }
//        }
//    }

    public void addPlant(){
        plantsS.forEach((key, value) -> plantsS.compute(key, (k, v) -> v + 10));
    }

    public ConcurrentHashMap<Class<? extends Location>, Integer> getPlantsS() {
        return plantsS;
    }
}
