package Simulation;

import entity.Island;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Simulation {
    private volatile boolean isRunning = false;
    private final Island island;
    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);


    public Simulation(Island island) {
        this.island = island;
    }

    public void startSimulation() {
        if (isRunning) return;
        isRunning = true;

        scheduledExecutorService.scheduleAtFixedRate(island::addPlant,
                1,
                5,
                TimeUnit.SECONDS);
      //  System.out.println("Всего травы на острове: "+ island.getSumPlant());

    }

    public void stopSimulation() {
        isRunning = false;
        scheduledExecutorService.shutdownNow();
        }



}
