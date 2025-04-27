package service;

import entity.Island;
import entity.Plant;

public class Statistic {

    public String statisticFacts(Island island, Plant plant) {
        return "Всего травы на острове: "+plant.getSumPlant();
    }


}
