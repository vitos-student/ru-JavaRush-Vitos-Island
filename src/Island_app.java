import Simulation.Simulation;
import entity.Island;
import service.Statistic;

public class Island_app {
    public static void main(String[] args) {
        System.out.println("Начало симуляции");
        Island island = new Island();
        island.initLocation();
        island.initPlant();
        Statistic statistic = new Statistic();
        System.out.println(statistic.statisticFacts(island));
        System.out.println("я тут");
        Simulation simulation = new Simulation(island); // Создание движка симуляции
        simulation.startSimulation();
        island.addPlant();


        System.out.println(statistic.statisticFacts(island));
        simulation.stopSimulation();
        System.out.println("Конец симуляции");
    }
}
