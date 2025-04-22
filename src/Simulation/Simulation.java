package Simulation;

import entity.Island;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Simulation {

    private final Island island;
    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);


    public Simulation(Island island) {
        this.island = island;
    }

    public void startSimulation() {

    }
}
