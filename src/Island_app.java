import Simulation.Simulation;
import entity.Island;
import entity.Plant;
import service.Statistic;

public class Island_app {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Начало симуляции");
        Island island = new Island();
        island.initLocation();
       // island.initPlant();
        Plant plant = new Plant(island.getLocations());/** создаем траву на острове*/
        plant.initPlant();
        entity.Animal.HerbAnimal.Cow cow = new entity.Animal.HerbAnimal.Cow();

        Statistic statistic = new Statistic();
        Simulation simulation = new Simulation(island); // Создание движка симуляции
        simulation.startSimulation();

        simulation.stopSimulation();
        System.out.println("Конец симуляции");
    }
}
