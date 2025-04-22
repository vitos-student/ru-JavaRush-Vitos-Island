import Simulation.Simulation;
import entity.Island;
import service.Statistic;

public class Island_app {
    public static void main(String[] args) {
        System.out.println("Начало симуляции");
        Island island = new Island();
        island.initLocation();
        island.initPlant();
        Statistic statistic = new Statistic(island);
        Simulation simulation = new Simulation(island); // Создание движка симуляции
        simulation.startSimulation();

        System.out.println("Конец симуляции");
    }
}
