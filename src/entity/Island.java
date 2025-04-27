package entity;
import repository.ConfigVar;

public class Island {

    private int x = ConfigVar.X;
    private int y = ConfigVar.Y;
    public Location[][] locations;

    public Island() {
        this.locations = new Location[x][y];
        System.out.println("Остров создан");
    }

    public void initLocation() {
        for (int i = 0; i < ConfigVar.X; i++) {
            for (int j = 0; j < ConfigVar.Y; j++) {
                locations[i][j] = new Location(i, j);
            }
        }
    }

    public Location[][] getLocations() {
        return locations;
    }

    public Location getLocationsIsland(int x,int y) {
       return locations[x][y];
    }

}
