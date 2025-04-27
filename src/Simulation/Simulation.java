package Simulation;

import entity.Island;
import entity.Plant;
import service.ServiceAnimal;
import service.ServicePlant;
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
    ServiceAnimal serviceAnimal;
    ServicePlant servicePlant;


    public Simulation(Island island,Plant plants) {
        this.island = island;
        this.plant = plants;
        this.serviceAnimal = new ServiceAnimal(island);
        this.servicePlant = new ServicePlant(plant);
    }


    public void startSimulation() {
        if (isRunning) return;
        isRunning = true;

        /**  отдельный сервис для смены дня          */
        scheduledExecutorServiceStatistic.scheduleAtFixedRate(() -> soutStatistic(), 1, 1, TimeUnit.SECONDS);

       /**    сервисы с растениями и животными         */
        scheduledExecutorService.scheduleAtFixedRate(
                () -> servicePlant.addPlant(),
                1,
                5,
                TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(
                () -> serviceAnimal.addAnimalWeight(plant),
                1,
                5,
                TimeUnit.SECONDS);


        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


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
            System.out.println(statistic.statisticFacts(island, plant,serviceAnimal));
        }
    }


}
