package service;

import entity.Island;

public class Statistic {

    public Statistic(Island island) {
        System.out.println("Всего травы на острове: "+ island.getSumPlant());
    }

}
