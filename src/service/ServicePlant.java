package service;

import entity.Location;
import entity.Plant;

public class ServicePlant {
    private  final Plant plantsS;

    public ServicePlant(Plant plants) {
        this.plantsS = plants;
    }

    /**
     * рост травы от 0 до 100
     */
    public void addPlant() {
        plantsS.getPlantsS().forEach((key, value) -> {
            if (value <= 90) {
                plantsS.getPlantsS().compute(key, (k, v) -> v + 10);
            }
        });
    }

    public int getValue(Location location){
        return plantsS.getPlantsS().getOrDefault(location, 0).intValue();    }


}
