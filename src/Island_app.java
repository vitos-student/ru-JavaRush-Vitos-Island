import entity.Island;
import entity.Location;
import entity.Plant;
import utils.RandomizerLocation;

public class Island_app {
    public static void main(String[] args) {
        System.out.println("Привет");
        Island island = new Island();
        island.initLocation();
        island.initPlant();
        System.out.println(island.getSumPlant());


    }
}
