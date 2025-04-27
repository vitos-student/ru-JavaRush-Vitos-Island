package Simulation;

import entity.Island;
import entity.Plant;
import service.InitAnimal;
import service.Statistic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Simulation {
    private volatile boolean isRunning = false;
    private final Island island;
    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
    private final ScheduledExecutorService scheduledExecutorServiceStatistic = Executors.newSingleThreadScheduledExecutor();
    private final AtomicInteger countDay = new AtomicInteger();
    Plant plant;
    Statistic statistic = new Statistic();
    InitAnimal initAnimal ;

    public Simulation(Island island) {

        this.island = island;
        this.plant = new Plant(island.getLocations());
        this.initAnimal=new InitAnimal(island);
    }


    public void startSimulation() {
        if (isRunning) return;
        isRunning = true;
        System.out.println(initAnimal.getSumEatAnimal());
        initAnimal.addAnimalWeight(plant);

        System.out.println(initAnimal.getSumEatAnimal());

        scheduledExecutorServiceStatistic.scheduleAtFixedRate(() -> soutStatistic(), 1, 1, TimeUnit.SECONDS);


        scheduledExecutorService.scheduleAtFixedRate(
                //()->addPlant2(),
                () -> plant.addPlant(),
                1,
                5,
                TimeUnit.SECONDS);

        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //  System.out.println("Всего травы на острове: "+ island.getSumPlant());

    }


//    public void addPlant2(){
//        plantsSim.forEach((key, value) -> plantsSim.compute(key, (k, v) -> v + 10));
//    }

    public void stopSimulation() {
        isRunning = false;
        scheduledExecutorService.shutdownNow();
        scheduledExecutorServiceStatistic.shutdownNow();
    }

    public void soutStatistic() {
        int currentDay = countDay.incrementAndGet();
        System.out.println("День :" + currentDay);
        if (currentDay % 5 == 0) {
            System.out.println("Статистика развития:");
            System.out.println(statistic.statisticFacts(island, plant));
        }
    }


}
