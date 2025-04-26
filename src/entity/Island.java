package entity;

import repository.ConfigVar;
import java.util.concurrent.ConcurrentHashMap;

public class Island {

    private int x = ConfigVar.X;
    private int y = ConfigVar.Y;
    public Location[][] locations;
    private final ConcurrentHashMap<Class<? extends Location>, Integer> plants = new ConcurrentHashMap<>();

    public Island() {
        this.locations = new Location[x][y];
    }

    public void initLocation() {
        for (int i = 0; i < ConfigVar.X; i++) {
            for (int j = 0; j < ConfigVar.Y; j++) {
                locations[i][j] = new Location(i, j);
            }
        }
    }

    public void initPlant() {
        for (int i = 0; i < ConfigVar.X; i++) {
            for (int j = 0; j < ConfigVar.Y; j++) {
                plants.put(locations[i][j].getClass(), ConfigVar.WEIGHT_PLANT);
            }
        }
    }


    public int getSumPlant() {
        int sum = 0;
        for (int i = 0; i < ConfigVar.X; i++) {
            for (int j = 0; j < ConfigVar.Y; j++) {
              sum+=plants.get(locations[i][j].getClass());
            }
        }
        return sum;
    }

    public Location[][] getLocations() {
        return locations;
    }


    public void addPlant(){
        plants.forEach((key, value) -> plants.compute(key, (k, v) -> v + 10));
    }

    public ConcurrentHashMap<Class<? extends Location>, Integer> getPlants() {
        return plants;
    }
}
