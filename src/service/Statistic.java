package service;

import entity.Island;

public class Statistic {

    public String statisticFacts(Island island) {
       // System.out.println("Всего травы на острове: "+ island.getSumPlant());
        return "Всего травы на острове: "+ island.getSumPlant();
    }

}
