package entity.Animal.HerbAnimal;

import entity.Animal.Animal;
import entity.Location;

import java.util.concurrent.ConcurrentHashMap;

public class Cow extends Animal{

        private  final String nameAnimal = "Корова";
        private final Location[][] locations;
        private final int weight;
      //  private final ConcurrentHashMap<Class<? extends Location>, Integer> animal = new ConcurrentHashMap<>();


//    public Cow(Location[][] locations) {
//        this.locations =locations;
//        initAnimal(getNameAnimal(),locations);
//    }

    public Cow(int weight, int step, int maxCountLocation, int eatAnimal, Location[][] locations, int weight1) {
        super(weight, step, maxCountLocation, eatAnimal);
        this.locations = locations;
        this.weight = weight1;
    }


    public String getNameAnimal() {
        return nameAnimal;
    }
}


