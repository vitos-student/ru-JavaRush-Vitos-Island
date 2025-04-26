package service;

import entity.Island;
import entity.Plant;

public class Statistic {

    public String statisticFacts(Island island, Plant plant) {
       // System.out.println("Всего травы на острове: "+ island.getSumPlant());
       // return "Всего травы на острове: "+ island.getSumPlant();
        return "Всего травы на острове: "+plant.getSumPlant();
    }


}
