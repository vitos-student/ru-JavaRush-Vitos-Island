package service;

import entity.Island;
import entity.Plant;

public class Statistic {

    public String statisticFacts(Island island, Plant plant,ServiceAnimal serviceAnimal) {
        return "Всего травы на острове: "+plant.getSumPlant()
                + "\n"
                + "Общая сытость:" + serviceAnimal.getSumAllSatiety()
                + "\n"
                + "Больше всего животных на острове. Всего животных:" + serviceAnimal.getMaxAnimalLocation();
    }

}
